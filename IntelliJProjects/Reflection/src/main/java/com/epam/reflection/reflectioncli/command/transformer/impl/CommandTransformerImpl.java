package com.epam.reflection.reflectioncli.command.transformer.impl;

import java.util.Arrays;

import com.epam.reflection.reflectioncli.command.domain.Command;
import com.epam.reflection.reflectioncli.command.enumeration.CommandType;
import com.epam.reflection.reflectioncli.command.transformer.CommandTransformer;
import org.springframework.stereotype.Component;

@Component
public class CommandTransformerImpl implements CommandTransformer {
    @Override
    public Command transformCommand(String[] command) {
        return Command.builder()
            .withType(CommandType.getByName(command[0]))
            .withParameters(Arrays.copyOfRange(command, 1, command.length))
            .build();
    }
}
