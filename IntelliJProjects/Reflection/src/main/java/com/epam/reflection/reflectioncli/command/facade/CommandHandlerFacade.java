package com.epam.reflection.reflectioncli.command.facade;

import com.epam.reflection.reflectioncli.command.domain.Command;
import com.epam.reflection.reflectioncli.command.enumeration.CommandSource;
import com.epam.reflection.reflectioncli.command.exception.CommandException;

public interface CommandHandlerFacade {
    Command getCommandFrom(CommandSource commandSource) throws CommandException;
}
