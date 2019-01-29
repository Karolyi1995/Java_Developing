package com.epam.reflection.reflectioncli.command.validator;

import com.epam.reflection.reflectioncli.command.exception.InvalidCommandException;

public interface CommandValidator {
    void validateCommand(String[] command) throws InvalidCommandException;
}
