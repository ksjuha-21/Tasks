package ie.database;

import ie.constans.Constans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Okcana Severovostokova
 **/
public class DBConnectionPool {

    public static final String DATABASE_URL = "database.url";
    public static final String DATABASE_USER = "database.user";
    public static final String DATABASE_PASSWORD = "database.password";
    public static final String DATABASE_DRIVER = "database.driver";
    public static final String DATABASE_MAX_CONNECTIONS = "database.max.connections";
    public static final String DATABASE_WAIT_IF_BUSY = "database.wait.if.busy";

    private static DBConnectionPool instance;

    private String driver;
    private String url;
    private String user;
    private String pass;
    private int maxConnections;
    private boolean waitIfBusy;

    private LinkedBlockingQueue<Connection> availableConnections;
    private LinkedBlockingQueue<Connection> busyConnections;

    private DBConnectionPool() throws DBConnectionException {
        this.driver = Constans.getString(DATABASE_DRIVER);
        this.url = Constans.getString(DATABASE_URL);
        this.user = Constans.getString(DATABASE_USER);
        this.pass = Constans.getString(DATABASE_PASSWORD);
        this.maxConnections = Integer.valueOf(Constans.getString(DATABASE_MAX_CONNECTIONS));
        this.waitIfBusy = Boolean.valueOf(Constans.getString(DATABASE_WAIT_IF_BUSY));

        availableConnections = new LinkedBlockingQueue<Connection>(maxConnections);
        busyConnections = new LinkedBlockingQueue<Connection>();
        for (int i = 0; i < maxConnections; i++) {
            availableConnections.add(newConnection());
        }
    }

    public static DBConnectionPool getInstance() throws DBConnectionException {
        if (null == instance) {
            instance = new DBConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() throws DBConnectionException {
        Connection connection;
        if (!availableConnections.isEmpty()) {
            connection = availableConnections.poll();
            try {
                if (connection.isClosed()) {
                    return (getConnection());
                } else {
                    busyConnections.add(connection);
                    return connection;
                }
            } catch (SQLException e) {
                throw new DBConnectionException("KeyWordsDAOImpl access error.", e);
            }
        } else {
            if (totalConnections() < maxConnections) {
                connection = newConnection();
                availableConnections.add(connection);
                return (getConnection());
            } else {
                if (waitIfBusy) { //коллекция синхр-я так что он сам будет ждать
                    try {
                        connection = availableConnections.take();
                        busyConnections.add(connection);
                        return connection;
                    } catch (InterruptedException e) {
                        throw new DBConnectionException("Interrapted while waiting for connection became available.", e);
                    }
                } else {
                    throw new DBConnectionException("Connection limit reached.");
                }
            }
        }
    }

    private Connection newConnection() throws DBConnectionException {
        try {
            Class.forName(driver);
            Connection connection = DriverManager
                    .getConnection(url, user, pass);
            return (connection);
        } catch (SQLException e) {
            throw new DBConnectionException("Unable to create new connection. ", e);
        } catch (ClassNotFoundException e) {
            throw new DBConnectionException("Can't find class for driver:" + driver, e);
        }
    }

    public void free(Connection connection) {
        busyConnections.remove(connection);
        availableConnections.add(connection);
    }

    public int totalConnections() {
        return (availableConnections.size() + busyConnections.size());
    }

    public void closeAllConnections() throws DBConnectionException {
        closeConnections(availableConnections);
        closeConnections(busyConnections);
    }

    private void closeConnections(LinkedBlockingQueue<Connection> connections)
            throws DBConnectionException {
        try {
            for (Connection connection : connections) {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            throw new DBConnectionException("Error in connection closing.", e);
        }
    }
}
