package ie.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * @author Okcana Severovostokova
 **/
public interface KeyWordsDAO {

    String getClassNameByKeyWord(String keyword);

    void closeResultSet(ResultSet rs);

    void closeStatement(Statement st);

    void freeConnection();
}
