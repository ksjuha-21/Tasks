package ie.globalcom;

import ie.model.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by toshiba_admin on 27.06.2017.
 */
public class Bell implements Thing {

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("keyword");
        if (keyword.equals("ring")) {

            Result.getInstance().setResult("I am ring!");
        }
        else if (keyword.equals("bell")){
            Result.getInstance().setResult("I am bell!");
        }

    }
}
