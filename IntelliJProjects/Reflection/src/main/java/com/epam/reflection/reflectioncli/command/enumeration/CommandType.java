package com.epam.reflection.reflectioncli.command.enumeration;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public enum  CommandType {
    VISIBILITY_MODE("visibility-mode", 1, 1, ImmutableMap.of(
        1,
        ImmutableSet.of(
            "all",
            "non-private"
        )
    ), "visibility-mode <all|non-private>"),
    DESCRIBE("describe", 0, 1, ImmutableMap.of(
        1,
        ImmutableSet.of(
            "methods",
            "fields",
            "constructors"
        )
    ), "describe <|fields|methods|constructors>"),
    DETAILS("details", 2, 2, ImmutableMap.of(
        1,
        ImmutableSet.of(
            "method",
            "field"
        )
    ), "details <field|method> <member_name>"),
    INVOKE("invoke", 2, -1, Collections.emptyMap(), "invoke <method_name> <method_parameters>"),
    EXIT("exit", 0, 0, Collections.emptyMap(), "exit");

    private final String name;
    private final int minParameterCount;
    private final int maxParameterCount;
    private final Map<Integer, Set<String>> permittedParameters;
    private final String usage;

    CommandType(String name, int minParameterCount, int maxParameterCount, Map<Integer, Set<String>> permittedParameters, String usage) {
        this.name = name;
        this.minParameterCount = minParameterCount;
        this.maxParameterCount = maxParameterCount;
        this.permittedParameters = permittedParameters;
        this.usage = usage;
    }

    public static CommandType getByName(String command) {
        for (CommandType commandType : values()) {
            if (commandType.getName().equals(command)) {
                return commandType;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getMinParameterCount() {
        return minParameterCount;
    }

    public int getMaxParameterCount() {
        return maxParameterCount;
    }

    public Map<Integer, Set<String>> getPermittedParameters() {
        return permittedParameters;
    }

    public String getUsage() {
        return usage;
    }
}
