package ie.model;

import ie.dao.KeyWordsDAOImpl;
import ie.constans.Constans;
import ie.globalcom.Thing;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Okcana Severovostokova
 **/
public class RequestHelper {
    private static RequestHelper;

    String keyword;
    KeyWordsDAOImpl keyWordsDAO = new KeyWordsDAOImpl();
    String className;

    private RequestHelper() {
        instance = null;
    }

    public Thing getCommand(HttpServletRequest request) {

        keyword = request.getParameter("keyword");
        className = keyWordsDAO.getClassNameByKeyWord(keyword);
        Class<?> act = null;

        try {
            act = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Thing thing = null;
        if (act != null) {
            try {
                thing = (Thing) act.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if (thing != null) {
            return thing;
        } else {
            Result.getInstance().setResult(Constans.PAGE_ERROR);
        }
        return thing;
    }

    public static RequestHelper getInstance() {
        if (instance == null) {
            instance = new RequestHelper();
        }
        return instance;
    }
}
