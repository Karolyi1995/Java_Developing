package com.epam.reflection.reflectioncli.command.enumeration;

public enum VisibilityMode {
    ALL("all"),
    NON_PRIVATE("non-private");

    private final String name;

    VisibilityMode(String name) {
        this.name = name;
    }

    public static VisibilityMode getByName(String name) {
        for (VisibilityMode visibilityMode : values()) {
            if (visibilityMode.getName().equals(name)) {
                return visibilityMode;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
