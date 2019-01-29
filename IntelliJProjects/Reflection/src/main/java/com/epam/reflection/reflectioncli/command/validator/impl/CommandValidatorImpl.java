package com.epam.reflection.reflectioncli.command.validator.impl;

import java.util.Arrays;
import java.util.Set;

import com.epam.reflection.reflectioncli.command.enumeration.CommandType;
import com.epam.reflection.reflectioncli.command.exception.InvalidCommandException;
import com.epam.reflection.reflectioncli.command.validator.CommandValidator;
import org.springframework.stereotype.Component;

@Component
public class CommandValidatorImpl implements CommandValidator {
    //private static final Logger LOG = LoggerFactory.getLogger(CommandValidatorImpl.class);

    public void validateCommand(String[] command) throws InvalidCommandException {
        String commandName = command[0];
        String[] parameters = Arrays.copyOfRange(command, 1, command.length);
        CommandType commandType = CommandType.getByName(commandName);
        if (commandType == null) {
            //LOG.error("Cannot recognise command with name: {}", commandName);
            throw new InvalidCommandException("Command could not be recognised.");
        }
        validateParameterCount(commandType, parameters.length);
        validateParameterValues(commandType, parameters);
    }

    private void validateParameterCount(CommandType commandType, int parameterCount) throws InvalidCommandException {
        boolean parametersCountOK =
                commandType.getMinParameterCount() <= parameterCount
                        && (commandType.getMaxParameterCount() == -1 || commandType.getMaxParameterCount() >= parameterCount);
        if (! parametersCountOK) {
            String reason;
            if (commandType.getMinParameterCount() > parameterCount) {
                reason = "smaller";
            } else {
                reason = "bigger";
            }
            //LOG.error("Parameter count \"{}\" is {} than the permitted parameter count for command {}.", parameterCount, reason, commandType.getName());
            throw new InvalidCommandException("Parameter count doesn't match.");
        }
    }

    private void validateParameterValues(CommandType commandType, String[] parameters) throws InvalidCommandException{
        for (int i = 0 ; i < parameters.length ; i++) {
            Set<String> permittedParameterValuesForPlace = commandType.getPermittedParameters().get(i + 1);
            if (permittedParameterValuesForPlace != null && !permittedParameterValuesForPlace.contains(parameters[i])) {
                //LOG.error("{} is invalid for place {} for command {}", parameters[i], i, commandType.getName());
                throw new InvalidCommandException("Invalid parameter(s).");
            }
        }
    }
}
