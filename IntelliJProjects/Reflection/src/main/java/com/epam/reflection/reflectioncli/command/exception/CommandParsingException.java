package com.epam.reflection.reflectioncli.command.exception;

import org.springframework.stereotype.Component;


public class CommandParsingException extends CommandException {
    public CommandParsingException(String message) {
        super(message);
    }

    public CommandParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
