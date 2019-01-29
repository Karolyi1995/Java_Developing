package com.epam.reflection.reflectioncli.command.processor;

import org.springframework.beans.factory.annotation.Autowired;

public interface CommandProcessor {
    void processCommand(String[] parameters);
}
