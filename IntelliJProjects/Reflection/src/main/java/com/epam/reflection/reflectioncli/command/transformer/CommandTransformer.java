package com.epam.reflection.reflectioncli.command.transformer;

import com.epam.reflection.reflectioncli.command.domain.Command;

public interface CommandTransformer {
    Command transformCommand(String[] command);
}
