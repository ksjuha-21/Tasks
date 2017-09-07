package ie.globalcom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by toshiba_admin on 27.06.2017.
 */
public interface Thing {
    void execute(HttpServletRequest request, HttpServletResponse response);
}
