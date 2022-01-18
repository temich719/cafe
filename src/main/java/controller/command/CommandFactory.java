package controller.command;

import controller.ControllerStringsStorage;
import controller.exception.ControllerException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class CommandFactory {

    private static final Logger LOGGER = Logger.getLogger(CommandFactory.class);
    private static final CommandFactory INSTANCE = new CommandFactory();

    private CommandFactory() {
    }

    public static CommandFactory getINSTANCE() {
        return INSTANCE;
    }

    public Command getCommand(HttpServletRequest request) throws ControllerException {
        String commandName = request.getParameter(ControllerStringsStorage.COMMAND);
        Command command = CommandEnum.ERROR_COMMAND.getCommand();
        if (Objects.nonNull(commandName) && !commandName.isEmpty()) {
            try {
                command = CommandEnum.valueOf(commandName).getCommand();
            } catch (IllegalArgumentException e) {
                throw new ControllerException(e);
            }
        } else {
            LOGGER.error("Illegal arguments in CommandFactory");
        }
        return command;
    }
}
