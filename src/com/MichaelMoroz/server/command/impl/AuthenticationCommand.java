package com.MichaelMoroz.server.command.impl;

import com.MichaelMoroz.server.command.Command;
import com.MichaelMoroz.server.command.exception.CommandException;
import com.MichaelMoroz.server.model.AuthType;
import com.MichaelMoroz.server.service.ServiceFactory;

public class AuthenticationCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        var arguments = request.split(" ");
        if (arguments.length != 2) throw new CommandException("AUTH command should contain 1 argument");
        AuthType authType;
        try {
            authType = AuthType.valueOf(arguments[1]);
        } catch (IllegalArgumentException e) {
            throw new CommandException("No such auth type");
        }

        ServiceFactory.getInstance().getAuthService().setAuthType(caller, authType);
        return "Success.";
    }
}
