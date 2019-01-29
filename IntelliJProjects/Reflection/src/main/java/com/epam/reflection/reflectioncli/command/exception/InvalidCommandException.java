package com.epam.reflection.reflectioncli.command.exception;

import org.springframework.stereotype.Component;


public class InvalidCommandException extends CommandException {
    public InvalidCommandException(String message) {
        super(message);
    }

    public InvalidCommandException(String message, Throwable cause) {
        super(message, cause);
    }
}
