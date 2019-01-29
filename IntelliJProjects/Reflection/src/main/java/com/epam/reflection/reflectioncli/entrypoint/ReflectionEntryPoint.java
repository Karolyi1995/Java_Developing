package com.epam.reflection.reflectioncli.entrypoint;

import com.epam.reflection.reflectioncli.command.enumeration.CommandSource;
import com.epam.reflection.reflectioncli.command.enumeration.CommandType;
import com.epam.reflection.reflectioncli.command.exception.CommandException;
import com.epam.reflection.reflectioncli.command.facade.CommandHandlerFacade;
import com.epam.reflection.reflectioncli.config.ConfigCLI;
import com.epam.reflection.reflectioncli.context.ReflectionCLIContext;
import com.epam.reflection.reflectioncli.command.dispatcher.ReflectionCommandDispatcher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReflectionEntryPoint {
    private static ReflectionCLIContext context;

    public static ReflectionCLIContext getContext() {
        return context;
    }

    public static void main(String[] args) {
        ApplicationContext springcontext = new AnnotationConfigApplicationContext(ConfigCLI.class);
        context = new ReflectionCLIContext();
        CommandHandlerFacade commandHandlerFacade2 = (CommandHandlerFacade) springcontext.getBean("commandHandlerFacadeImpl");
        ReflectionCommandDispatcher reflectionProcessor2 = (ReflectionCommandDispatcher) springcontext.getBean("reflectionCommandDispatcherImpl");
        do {
            boolean shouldExit = false;
            try {
                 shouldExit = reflectionProcessor2.dispatchCommand(commandHandlerFacade2.getCommandFrom(CommandSource.CONSOLE));
            } catch (CommandException e) {
                System.err.println(e.getMessage());
                printUsage();
            }
            if (shouldExit) {
                break;
            }
        } while (true);
        System.out.println("Exiting");
    }

    private static void printUsage() {
        System.err.println("Usage: ");
        for (CommandType commandType : CommandType.values()) {
            System.err.print("    ");
            System.err.println(commandType.getUsage());
        }
    }
}
