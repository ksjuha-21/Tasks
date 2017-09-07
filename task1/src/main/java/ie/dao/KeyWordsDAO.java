package ie.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Created by toshiba_admin on 27.06.2017.
 */
public interface KeyWordsDAO {

    String getClassNameByKeyWord(String keyword);

    void closeResultSet(ResultSet rs);

    void closeStatement(Statement st);

    void freeConnection();
}
