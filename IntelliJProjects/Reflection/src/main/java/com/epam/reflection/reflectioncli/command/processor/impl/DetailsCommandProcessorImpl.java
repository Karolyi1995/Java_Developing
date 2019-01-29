package com.epam.reflection.reflectioncli.command.processor.impl;

import com.epam.reflection.reflectioncli.command.enumeration.VisibilityMode;
import com.epam.reflection.reflectioncli.entrypoint.ReflectionEntryPoint;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class DetailsCommandProcessorImpl extends AbstractCommandProcessorImpl {
    @Override
    public void processCommand(String[] parameters) {
        String type = parameters[0];
        String name = parameters[1];
        VisibilityMode currentVisibilityMode = ReflectionEntryPoint.getContext().getVisibilityMode();
        switch (type) {
            case "field":
                fieldDetails(currentVisibilityMode, name);
                break;
            case "method":
                methodDetails(currentVisibilityMode, name);
                break;
        }
    }

    private void fieldDetails(VisibilityMode visibilityMode, String name) {
        try {
            Field field = ReflectionEntryPoint.getContext().getReflectedClass().getDeclaredField(name);
            if (! shouldSkip(field.getModifiers(), visibilityMode)) {
                System.out.println(getAnnotations(field.getAnnotations()) + getModifiers(field.getModifiers())+ field.getType().getName() + " " + field.getName());
            } else {
                System.out.println("Details of the current field cannot be retrieved in the current visibility mode");
            }
        } catch (NoSuchFieldException e) {
            System.out.println("Field with the given name doesn't exist.");
        }
    }

    private void methodDetails(VisibilityMode visibilityMode, String name) {
        Method method = getMethodByName(name, visibilityMode);
        if (method != null) {
            System.out.println(
                getAnnotations(method.getAnnotations()) +
                getModifiers(method.getModifiers()) +
                " " +
                method.getReturnType().getName() +
                " " +
                method.getName() +
                getParameters(method) +
                " " +
                getExceptionTypes(method));
        } else {
            System.out.println("No method with given name found, or details of the current method cannot be retrieved in the current visibility mode");
        }
    }

    private Method getMethodByName(String name, VisibilityMode visibilityMode) {
        for (Method method : ReflectionEntryPoint.getContext().getReflectedClass().getDeclaredMethods()) {
            if (method.getName().equals(name) && !shouldSkip(method.getModifiers(), visibilityMode)) {
                return method;
            }
        }
        return null;
    }

    private String getAnnotations(Annotation[] annotations) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (Annotation annotation : annotations) {
            stringBuilder.append("@").append(annotation.annotationType().getName()).append(" ");
        }
        return stringBuilder.toString();
    }

    private String getModifiers(int modifiers) {
        StringBuilder stringBuilder = new StringBuilder("");
        if ((modifiers & Modifier.PUBLIC) > 0) {
            stringBuilder.append("public").append(" ");
        }
        if ((modifiers & Modifier.PROTECTED) > 0) {
            stringBuilder.append("protected").append(" ");
        }
        if ((modifiers & Modifier.PRIVATE) > 0) {
            stringBuilder.append("private").append(" ");
        }
        if ((modifiers & Modifier.ABSTRACT) > 0) {
            stringBuilder.append("abstract").append(" ");
        }
        if ((modifiers & Modifier.FINAL) > 0) {
            stringBuilder.append("final").append(" ");
        }
        if ((modifiers & Modifier.INTERFACE) > 0) {
            stringBuilder.append("interface");
        }
        if ((modifiers & Modifier.NATIVE) > 0) {
            stringBuilder.append("native").append(" ");
        }
        if ((modifiers & Modifier.STATIC) > 0) {
            stringBuilder.append("static").append(" ");
        }
        if ((modifiers & Modifier.STRICT) > 0) {
            stringBuilder.append("strict").append(" ");
        }
        if ((modifiers & Modifier.SYNCHRONIZED) > 0) {
            stringBuilder.append("synchronized").append(" ");
        }
        if ((modifiers & Modifier.TRANSIENT) > 0) {
            stringBuilder.append("transient").append(" ");
        }
        if ((modifiers & Modifier.VOLATILE) > 0) {
            stringBuilder.append("volatile").append(" ");
        }
        return stringBuilder.substring(0, modifiers > 0 ? stringBuilder.length() - 1 : stringBuilder.length());
    }

    private String getParameters(Method method) {
        StringBuilder stringBuilder = new StringBuilder("(");
        boolean areParametersPresent = method.getParameters().length > 0;
        for(Parameter parameter : method.getParameters()) {
            stringBuilder.append(parameter.getType().getName()).append(" ").append(parameter.getName()).append(", ");
        }
        return stringBuilder.substring(0, areParametersPresent ? stringBuilder.length() - 2 : stringBuilder.length()) + ")";
    }

    private String getExceptionTypes(Method method) {
        StringBuilder stringBuilder = new StringBuilder(method.getExceptionTypes().length > 0 ? "throws ": "");
        boolean areThrowableExceptionsPresent = method.getExceptionTypes().length > 0;
        for(Class<?> exceptionType : method.getExceptionTypes()) {
            stringBuilder.append(exceptionType.getName()).append(", ");
        }
        return stringBuilder.substring(0, areThrowableExceptionsPresent ? stringBuilder.length() - 2 : stringBuilder.length());
    }
}
