package ie.controller;

import ie.globalcom.Thing;
import ie.model.RequestHelper;
import ie.model.Result;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet implements javax.servlet.Servlet {

    RequestHelper requestHelper = RequestHelper.getInstance();
    private Result result = Result.getInstance();

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Thing thing = requestHelper.getCommand(request);
            thing.execute(request, response);
            response.setContentType("text/plain");
            response.getWriter().write(result.getResult());
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}

