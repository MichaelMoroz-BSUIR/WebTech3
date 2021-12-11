package com.MichaelMoroz.server.command.impl;

import com.MichaelMoroz.server.command.Command;
import com.MichaelMoroz.server.command.exception.CommandException;
import com.MichaelMoroz.server.model.AuthType;
import com.MichaelMoroz.server.service.ServiceFactory;

public class DisconnectCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        ServiceFactory.getInstance().getAuthService().setAuthType(caller, AuthType.UNAUTH);
        return "Bye bye!";
    }
}
