package webapp.servlet;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private static final Context INSTANCE = new Context();
    private static Map users;

    private Context(){
        users = new HashMap();
    }

    public static Context getContext(){
        return INSTANCE;
    }

    public static Map getMap(){
        return users;
    }
}
