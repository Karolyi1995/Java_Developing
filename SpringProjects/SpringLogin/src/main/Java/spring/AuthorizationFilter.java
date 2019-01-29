package spring;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthorizationFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        if(request.getSession().getAttribute("username")!=null){
            fc.doFilter(req,resp);
        }else{
            request.getRequestDispatcher("/AuthenticationRequired.jsp").forward(req,resp);
        }
    }
}
