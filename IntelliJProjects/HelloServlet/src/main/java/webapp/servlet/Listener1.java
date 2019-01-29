package webapp.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener1 implements ServletContextListener {

    public void contextInitialized(ServletContextEvent e) {
        System.out.println(e.getServletContext());
    }

    public void contextDestroyed(ServletContextEvent e) {
        System.out.println("Context Destroyed");
    }
}
