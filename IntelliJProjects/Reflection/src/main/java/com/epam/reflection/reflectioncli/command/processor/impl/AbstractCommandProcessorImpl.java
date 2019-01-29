package com.epam.reflection.reflectioncli.command.processor.impl;

import com.epam.reflection.reflectioncli.command.enumeration.VisibilityMode;
import com.epam.reflection.reflectioncli.command.processor.CommandProcessor;

import java.lang.reflect.Modifier;

abstract class AbstractCommandProcessorImpl implements CommandProcessor {
    boolean shouldSkip(int modifiers, VisibilityMode visibilityMode) {
        return VisibilityMode.NON_PRIVATE.equals(visibilityMode) && (modifiers & Modifier.PRIVATE) == Modifier.PRIVATE;
    }
}
