package ie.database;

/**
 * Created by toshiba_admin on 16.03.2017.
 */
public class DBConnectionException extends Exception {
    private Exception e;

    public DBConnectionException() {
        super();
    }

    public DBConnectionException(String message) {
        super(message);
    }

    public DBConnectionException(String message, Exception e) {
        super(message, e);
    }

    Exception getDBConnectionException() {
        return e;
    }
}
