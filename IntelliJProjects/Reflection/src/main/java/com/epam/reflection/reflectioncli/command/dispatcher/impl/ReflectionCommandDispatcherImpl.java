package com.epam.reflection.reflectioncli.command.dispatcher.impl;

import com.epam.reflection.reflectioncli.command.domain.Command;
import com.epam.reflection.reflectioncli.command.dispatcher.ReflectionCommandDispatcher;
import com.epam.reflection.reflectioncli.command.processor.CommandProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ReflectionCommandDispatcherImpl implements ReflectionCommandDispatcher {

    @Autowired
    @Qualifier("visibilityMode")
    private CommandProcessor visibilityModeCommandProcessor;
    @Autowired
    @Qualifier("describe")
    private CommandProcessor describeCommandProcessor;
    @Autowired
    @Qualifier("details")
    private CommandProcessor detailsCommandProcessor;
    @Autowired
    @Qualifier("invoke")
    private CommandProcessor invokeCommandProcessor;

    @Override
    public boolean dispatchCommand(Command command) {
        String[] parameters = command.getParameters();
        switch (command.getType()) {
            case VISIBILITY_MODE:
                visibilityModeCommandProcessor.processCommand(parameters);
                return false;
            case DESCRIBE:
                describeCommandProcessor.processCommand(parameters);
                return false;
            case DETAILS:
                detailsCommandProcessor.processCommand(parameters);
                return false;
            case INVOKE:
                invokeCommandProcessor.processCommand(parameters);
                return false;
            default:
                return true;
        }
    }

    public void setVisibilityModeCommandProcessor(CommandProcessor visibilityModeCommandProcessor) {
        this.visibilityModeCommandProcessor = visibilityModeCommandProcessor;
    }

    public void setDescribeCommandProcessor(CommandProcessor describeCommandProcessor) {
        this.describeCommandProcessor = describeCommandProcessor;
    }

    public void setDetailsCommandProcessor(CommandProcessor detailsCommandProcessor) {
        this.detailsCommandProcessor = detailsCommandProcessor;
    }

    public void setInvokeCommandProcessor(CommandProcessor invokeCommandProcessor) {
        this.invokeCommandProcessor = invokeCommandProcessor;
    }
}
