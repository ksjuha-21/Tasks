package ie.globalcom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Okcana Severovostokova
 **/
public interface Thing {
    void execute(HttpServletRequest request, HttpServletResponse response);
}
