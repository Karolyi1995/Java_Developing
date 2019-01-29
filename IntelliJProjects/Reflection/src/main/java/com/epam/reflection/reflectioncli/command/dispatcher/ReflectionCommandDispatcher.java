package com.epam.reflection.reflectioncli.command.dispatcher;

import com.epam.reflection.reflectioncli.command.domain.Command;

public interface ReflectionCommandDispatcher {
    boolean dispatchCommand(Command command);
}
