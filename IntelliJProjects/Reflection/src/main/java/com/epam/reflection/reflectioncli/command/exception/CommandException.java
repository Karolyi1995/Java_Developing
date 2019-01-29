package com.epam.reflection.reflectioncli.command.exception;

import org.springframework.stereotype.Component;


public class CommandException extends Exception {
    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }
}
