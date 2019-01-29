package com.epam.reflection.reflectioncli.command.domain;

import com.epam.reflection.reflectioncli.command.enumeration.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Command {

    private final CommandType type;
    private final String[] parameters;

    private Command(Builder builder) {
        this.type = builder.type;
        this.parameters = builder.parameters;
    }

    public static Builder builder() {
        return new Builder();
    }

    public CommandType getType() {
        return type;
    }

    public String[] getParameters() {
        return parameters;
    }

    public static class Builder {
        private CommandType type;
        private String[] parameters = new String[0];

        private Builder() {
        }

        public Builder withType(CommandType type) {
            this.type = type;
            return this;
        }

        public Builder withParameters(String[] parameters) {
            this.parameters = parameters;
            return this;
        }

        public Command build() {
            return new Command(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Name: " + this.type.getName()).append("\n");
        stringBuilder.append("Params:\n");
        for (String param: parameters) {
            stringBuilder.append("    " + param).append("\n");
        }
        return stringBuilder.toString();
    }
}
