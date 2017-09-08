package ie.dao;

import ie.database.DBConnectionException;
import ie.database.DBConnectionPool;

import java.io.Serializable;
import java.sql.*;

/**
 * @author Okcana Severovostokova
 **/
public class KeyWordsDAOImpl implements KeyWordsDAO {

    private Connection connection;
    public static final String DATABASE_ENCODING = "database.encoding";

    public KeyWordsDAOImpl() {
        try {
            this.connection = DBConnectionPool.getInstance().getConnection();
        } catch (DBConnectionException e) {
            e.printStackTrace();
        }
    }

    public String getClassNameByKeyWord(String keyword) {

        PreparedStatement st = null;
        ResultSet rs = null;
        String className = null;
        int binded_class;

        try {
            st = connection.prepareStatement("SELECT binded_class FROM keywords WHERE keyword = ?");
            st.setString(1, keyword);
            rs = st.executeQuery();
            if (rs.next()) {
                binded_class = rs.getInt("binded_class");

                st = connection.prepareStatement("SELECT classname FROM classes WHERE id = ?");
                st.setLong(1, binded_class);
                rs = st.executeQuery();
                if (rs.next()) {
                    className = rs.getString("classname");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResultSet(rs);
            this.closeStatement(st);
        }
        return className;
    }

    public void closeResultSet(ResultSet rs) {
    }

    public void closeStatement(Statement st) {
    }

    public void freeConnection() {
    }
}
