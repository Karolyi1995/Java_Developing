package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthenticationController {

    @RequestMapping("/Hello")
    public String handle(HttpServletRequest req, HttpServletResponse resp){
        if(req.getSession().getAttribute(SpringLoginInterface.SESSIONKEY)!=null){
            return "HelloUser";
        }
        else{
            return "AuthenticationRequired";
        }
    }
}
