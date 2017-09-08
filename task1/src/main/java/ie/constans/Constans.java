package ie.constans;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Okcana Severovostokova
 **/
public class Constans {

    public Constans() {
    }

    public final static String PAGE_INDEX = "index.jsp";
    public final static String PAGE_ERROR = "jsp/error.jsp";
    public static final String PARAM_MESSAGE = "message";
    private static final String RESOURCE_PATH = "config";

    private static ResourceBundle resource = ResourceBundle.getBundle(RESOURCE_PATH, Locale.getDefault());

    public static String getString(String key) {
        return resource.getString(key);
    }

    public static void setLocale(Locale locale) {
        if (null != locale) {
            resource = ResourceBundle.getBundle(RESOURCE_PATH, locale);
        } else {
            resource = ResourceBundle.getBundle(RESOURCE_PATH, Locale.getDefault());
        }
    }
}
