package com.epam.reflection.reflectioncli.command.processor.impl;

import com.epam.reflection.reflectioncli.command.enumeration.VisibilityMode;
import com.epam.reflection.reflectioncli.command.processor.CommandProcessor;
import com.epam.reflection.reflectioncli.entrypoint.ReflectionEntryPoint;
import org.springframework.stereotype.Component;


public class VisibilityModeCommandProcessorImpl implements CommandProcessor {
    @Override
    public void processCommand(String[] parameters) {
        VisibilityMode newVisibilityMode = VisibilityMode.getByName(parameters[0]);
        ReflectionEntryPoint.getContext().setVisibilityMode(newVisibilityMode);
    }
}
