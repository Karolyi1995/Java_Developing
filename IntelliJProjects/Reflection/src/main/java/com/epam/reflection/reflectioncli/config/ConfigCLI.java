package com.epam.reflection.reflectioncli.config;

import com.epam.reflection.reflectioncli.command.processor.CommandProcessor;
import com.epam.reflection.reflectioncli.command.processor.impl.DescribeCommandProcessorImpl;
import com.epam.reflection.reflectioncli.command.processor.impl.DetailsCommandProcessorImpl;
import com.epam.reflection.reflectioncli.command.processor.impl.InvokeCommandProcessorImpl;
import com.epam.reflection.reflectioncli.command.processor.impl.VisibilityModeCommandProcessorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.epam.reflection.reflectioncli")
@Configuration
public class ConfigCLI {

    @Bean
    public CommandProcessor visibilityMode(){
        return new VisibilityModeCommandProcessorImpl();
    }

    @Bean
    public CommandProcessor describe(){
        return new DescribeCommandProcessorImpl();
    }

    @Bean
    public CommandProcessor details(){
        return new DetailsCommandProcessorImpl();
    }

    @Bean
    public CommandProcessor invoke(){
        return new InvokeCommandProcessorImpl();
    }
}
