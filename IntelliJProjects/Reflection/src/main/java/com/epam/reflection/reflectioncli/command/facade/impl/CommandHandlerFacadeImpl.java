package com.epam.reflection.reflectioncli.command.facade.impl;

import com.epam.reflection.reflectioncli.command.domain.Command;
import com.epam.reflection.reflectioncli.command.enumeration.CommandSource;
import com.epam.reflection.reflectioncli.command.exception.CommandException;
import com.epam.reflection.reflectioncli.command.exception.UnsupportedCommandSourceException;
import com.epam.reflection.reflectioncli.command.facade.CommandHandlerFacade;
import com.epam.reflection.reflectioncli.command.parser.CommandParser;
import com.epam.reflection.reflectioncli.command.transformer.CommandTransformer;
import com.epam.reflection.reflectioncli.command.validator.CommandValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandHandlerFacadeImpl implements CommandHandlerFacade {
    private static final String SEPARATOR = " ";
    private final CommandParser consoleCommandParser;
    private final CommandValidator commandValidator;
    private final CommandTransformer commandTransformer;

    @Autowired
    public CommandHandlerFacadeImpl(CommandParser consoleCommandParser, CommandValidator commandValidator, CommandTransformer commandTransformer) {
        this.consoleCommandParser = consoleCommandParser;
        this.commandValidator = commandValidator;
        this.commandTransformer = commandTransformer;
    }

    public Command getCommandFrom(CommandSource commandSource) throws CommandException {
        CommandParser selectedCommandParser;
        switch (commandSource) {
            case CONSOLE:
                selectedCommandParser = consoleCommandParser;
                break;
            default:
                throw new UnsupportedCommandSourceException(commandSource.name() + " source not supported");
        }
        return getCommand(selectedCommandParser);
    }

    private Command getCommand(CommandParser commandParser) throws CommandException {
        String[] command = commandParser.parseCommand().split(SEPARATOR);
        commandValidator.validateCommand(command);
        return commandTransformer.transformCommand(command);
    }
}
