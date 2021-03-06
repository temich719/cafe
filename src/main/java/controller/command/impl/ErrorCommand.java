package controller.command.impl;

import controller.command.Command;
import controller.exception.ControllerException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static controller.ControllerStringsStorage.*;

public class ErrorCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(ErrorCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        LOGGER.info("We got to ErrorCommand");
        return ERRORS + ERROR;
    }
}
