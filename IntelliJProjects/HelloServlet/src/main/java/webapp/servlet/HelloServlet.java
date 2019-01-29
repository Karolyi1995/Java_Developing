package webapp.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet{

    String message;

    @Override
    public void init(ServletConfig sc) throws ServletException {
        super.init(sc);
        message = sc.getInitParameter("name");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        ServletOutputStream os = resp.getOutputStream();
        os.println("Hello " + message + "!");
        if(req.getAttribute("filter1") != null){
            os.println("Int értéke: " + req.getAttribute("filter1"));
        }else{
            os.println("Nincs meg az attribútum");
        }
        os.flush();
    }
}
