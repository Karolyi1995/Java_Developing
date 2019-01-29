package com.epam.reflection.reflectioncli.command.parser.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.epam.reflection.reflectioncli.command.exception.CommandParsingException;
import com.epam.reflection.reflectioncli.command.parser.CommandParser;
import org.springframework.stereotype.Component;

@Component
public class ConsoleCommandParserImpl implements CommandParser {
    //private static final Logger LOG = LoggerFactory.getLogger(ConsoleCommandParserImpl.class);

    private BufferedReader consoleReader;

    public ConsoleCommandParserImpl() {
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String parseCommand() throws CommandParsingException {
        try {
            return consoleReader.readLine();
        } catch (IOException e) {
            //LOG.error("Failed to parse command from console", e);
            throw new CommandParsingException("Failed to parse a command", e);
        }
    }
}
