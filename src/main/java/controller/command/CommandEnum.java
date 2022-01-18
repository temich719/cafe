package controller.command;

import controller.command.impl.CreateOrderCommand;
import controller.command.impl.ErrorCommand;

public enum CommandEnum {
    ERROR_COMMAND(new ErrorCommand()),
    CREATE_ORDER_COMMAND(new CreateOrderCommand());

    CommandEnum(Command command){
        this.command = command;
    }

    Command command;

    Command getCommand(){
        return command;
    }
}
