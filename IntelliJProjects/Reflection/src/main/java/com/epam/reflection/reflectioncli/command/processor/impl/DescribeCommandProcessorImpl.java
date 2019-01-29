package com.epam.reflection.reflectioncli.command.processor.impl;

import com.epam.reflection.reflectioncli.command.enumeration.VisibilityMode;
import com.epam.reflection.reflectioncli.entrypoint.ReflectionEntryPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class DescribeCommandProcessorImpl extends AbstractCommandProcessorImpl {
    @Override
    public void processCommand(String[] parameters) {
        String type = parameters.length == 0 ? "all" : parameters[0];
        VisibilityMode currentVisibilityMode = ReflectionEntryPoint.getContext().getVisibilityMode();
        switch (type) {
            case "all":
                listMembers(currentVisibilityMode, ReflectionEntryPoint.getContext().getReflectedClass().getDeclaredFields());
                listMembers(currentVisibilityMode, ReflectionEntryPoint.getContext().getReflectedClass().getDeclaredMethods());
                listMembers(currentVisibilityMode, ReflectionEntryPoint.getContext().getReflectedClass().getDeclaredConstructors());
                break;
            case "fields":
                listMembers(currentVisibilityMode, ReflectionEntryPoint.getContext().getReflectedClass().getDeclaredFields());
                break;
            case "methods":
                listMembers(currentVisibilityMode, ReflectionEntryPoint.getContext().getReflectedClass().getDeclaredMethods());
                break;
            case "constructors":
                listMembers(currentVisibilityMode, ReflectionEntryPoint.getContext().getReflectedClass().getDeclaredConstructors());
                break;
        }
    }

    private void listMembers(VisibilityMode visibilityMode, Member[] members) {
        String type = getTypeByMembers(members.getClass());
        for(Member member : members) {
            int modifiers = member.getModifiers();
            if (!shouldSkip(modifiers, visibilityMode)) {
                System.out.println(type + member.getName());
            }
        }
    }

    private String getTypeByMembers(Class<? extends Member[]> clazz) {
        if (clazz.isAssignableFrom(Field[].class)) {
            return "Field: ";
        } else if (clazz.isAssignableFrom(Method[].class)) {
            return "Method: ";
        } else {
            return "Constructor: ";
        }
    }
}
