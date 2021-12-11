package com.MichaelMoroz.server.command.impl;

import com.MichaelMoroz.server.command.Command;
import com.MichaelMoroz.server.command.exception.CommandException;
import com.MichaelMoroz.server.model.AuthType;
import com.MichaelMoroz.server.service.ServiceFactory;

public class CreateCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        var arguments = request.split(" ");
        if (arguments.length != 3) throw new CommandException("CREATE invalid syntax");

        if (ServiceFactory.getInstance().getAuthService().getAuthType(caller) != AuthType.MANAGER)
            return "Should be MANAGER";

        ServiceFactory.getInstance().getCaseService().addCase(arguments[1], arguments[2]);
        return "Success";
    }
}
