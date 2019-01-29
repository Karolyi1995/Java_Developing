package com.epam.reflection.reflectioncli.command.exception;

import org.springframework.stereotype.Component;


public class UnsupportedCommandSourceException extends CommandException {
    public UnsupportedCommandSourceException(String message) {
        super(message);
    }

    public UnsupportedCommandSourceException(String message, Throwable cause) {
        super(message, cause);
    }
}
