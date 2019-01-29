package webapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class LoginProcess extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Context.getMap().containsKey(req.getParameter("username")) && req.getParameter("password").equals(Context.getMap().get(req.getParameter("username")))){
            HttpSession session = req.getSession();
            session.setAttribute("username",req.getParameter("username"));
            req.getRequestDispatcher("/LoginSuccess.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/LoginError.jsp").forward(req,resp);
        }
    }
}
