package com.epam.reflection.reflectioncli.reflect;

import com.epam.reflection.reflectioncli.command.annotation.TimeMetered;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

public class TestClass {
    protected static final Object object = null;

    private Integer integer;
    String str;

    @Deprecated
    @PostConstruct
    public int doSomething(Object o, Integer io, int i) throws IOException, NumberFormatException {
        return 0;
    }

    @TimeMetered
    private int getObject(String string) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return string.length();
    }

    public String getObject2(String string, String string2)
    {
        return string.concat(string2);
    }
}
