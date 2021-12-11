package com.MichaelMoroz.server.command;

import com.MichaelMoroz.server.command.exception.CommandException;

public interface Command {
    String execute(Object caller, String request) throws CommandException;
}
