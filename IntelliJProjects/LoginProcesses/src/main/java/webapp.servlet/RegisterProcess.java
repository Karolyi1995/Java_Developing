package webapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegisterProcess extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Context.getMap().containsKey(req.getParameter("username"))){
            req.getRequestDispatcher("/RegisterError.jsp");
        }else{
            Context.getMap().put(req.getParameter("username"),req.getParameter("password"));
            req.getRequestDispatcher("/RegisterSuccess.jsp").forward(req,resp);
        }
    }
}
