package controller;

import controller.command.CommandFactory;
import controller.exception.ControllerException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controller.ControllerStringsStorage.*;

public class FrontController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(FrontController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doExecute(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doExecute(req, resp);
    }

    private String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        return CommandFactory.getINSTANCE().getCommand(request).execute(request, response);
    }

    private void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String forward = handleRequest(request, response);
            request.getRequestDispatcher(WEB_INF + forward + DOT_JSP).forward(request, response);
        } catch (ControllerException | ServletException | IOException e) {
            LOGGER.error("Something went wrong");
            request.setAttribute(ERROR, e.getMessage());
            request.getRequestDispatcher(WEB_INF + ERRORS + ERROR + DOT_JSP).forward(request, response);
        }
    }
}
