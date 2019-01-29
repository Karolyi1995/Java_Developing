package com.epam.reflection.reflectioncli.context;

import com.epam.reflection.reflectioncli.command.enumeration.VisibilityMode;
import com.epam.reflection.reflectioncli.command.facade.CommandHandlerFacade;
import com.epam.reflection.reflectioncli.command.facade.impl.CommandHandlerFacadeImpl;
import com.epam.reflection.reflectioncli.command.parser.CommandParser;
import com.epam.reflection.reflectioncli.command.parser.impl.ConsoleCommandParserImpl;
import com.epam.reflection.reflectioncli.command.processor.CommandProcessor;
import com.epam.reflection.reflectioncli.command.processor.impl.DescribeCommandProcessorImpl;
import com.epam.reflection.reflectioncli.command.processor.impl.DetailsCommandProcessorImpl;
import com.epam.reflection.reflectioncli.command.processor.impl.InvokeCommandProcessorImpl;
import com.epam.reflection.reflectioncli.command.processor.impl.VisibilityModeCommandProcessorImpl;
import com.epam.reflection.reflectioncli.command.transformer.CommandTransformer;
import com.epam.reflection.reflectioncli.command.transformer.impl.CommandTransformerImpl;
import com.epam.reflection.reflectioncli.command.validator.CommandValidator;
import com.epam.reflection.reflectioncli.command.validator.impl.CommandValidatorImpl;
import com.epam.reflection.reflectioncli.command.dispatcher.ReflectionCommandDispatcher;
import com.epam.reflection.reflectioncli.command.dispatcher.impl.ReflectionCommandDispatcherImpl;
import com.epam.reflection.reflectioncli.reflect.TestClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class ReflectionCLIContext {

    private final Class<?> reflectedClass = TestClass.class;
    private VisibilityMode visibilityMode = VisibilityMode.NON_PRIVATE;
    private TestClass instance;

    public ReflectionCLIContext() {
        try {
            instance = TestClass.class.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            instance = null;
        }
    }

    public void setVisibilityMode(VisibilityMode visibilityMode) {
        System.out.println("Setting visibility mode from " + this.visibilityMode.getName() + " to " + visibilityMode.getName());
        this.visibilityMode = visibilityMode;
    }

    public VisibilityMode getVisibilityMode() {
        return this.visibilityMode;
    }

    public Class<?> getReflectedClass() {
        return reflectedClass;
    }

    public TestClass getInstance() {
        return instance;
    }
}
