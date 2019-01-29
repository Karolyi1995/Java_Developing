package com.epam.reflection.reflectioncli.command.processor.impl;

import com.epam.reflection.reflectioncli.command.annotation.TimeMetered;
import com.epam.reflection.reflectioncli.command.processor.CommandProcessor;
import com.epam.reflection.reflectioncli.entrypoint.ReflectionEntryPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvokeCommandProcessorImpl implements CommandProcessor {
    @Override
    public void processCommand(String[] parameters) {
        if (ReflectionEntryPoint.getContext().getInstance() != null) {
            String methodName = parameters[0];
            String[] methodParameters = Arrays.copyOfRange(parameters, 1, parameters.length);
            List<Class<String>> parameterTypeList = new ArrayList<>(methodParameters.length);
            for (String ignored : methodParameters) {
                parameterTypeList.add(String.class);
            }
            callMethod(methodName, parameterTypeList, methodParameters);
        } else {
            System.out.println("Instantiation failed, invoking cannot be completed.");
        }
    }

    private void callMethod(String methodName, List<Class<String>> parameterTypeList, Object[] methodParameters) {
        try {
            Method method = ReflectionEntryPoint.getContext().getReflectedClass().getDeclaredMethod(methodName, parameterTypeList.toArray(new Class<?>[0]));
            method.setAccessible(true);
            long methodStartTime = System.currentTimeMillis();
            Object result = method.invoke(ReflectionEntryPoint.getContext().getInstance(), methodParameters);
            long runTime = System.currentTimeMillis() - methodStartTime;
            if (isMethodTimed(method)) {
                System.out.println("Execution time: " + runTime);
            }
            System.out.println("Invocation returned: " + result);
        } catch (NoSuchMethodException e) {
            System.out.println("No method found.");
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println("Failed to invoke method.");
        }
    }

    private boolean isMethodTimed(Method method) {
        return method.getAnnotation(TimeMetered.class) != null;
    }
}
