package com.epam.reflection.reflectioncli.command.parser;

import com.epam.reflection.reflectioncli.command.exception.CommandParsingException;

public interface CommandParser {
    String parseCommand() throws CommandParsingException;
}
