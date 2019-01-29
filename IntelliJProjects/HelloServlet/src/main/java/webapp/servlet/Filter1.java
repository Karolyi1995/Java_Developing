package webapp.servlet;

import javax.servlet.*;
import java.io.IOException;

public class Filter1 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc) throws IOException, ServletException {
        req.setAttribute("filter1",(int)Math.random());
        System.out.println(req.getAttribute("filter1"));
        fc.doFilter(req,resp);
        System.out.println("A hívás lefutott");
    }
}
