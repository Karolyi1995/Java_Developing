package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SpringController {

    public SpringController(){
        System.out.println("#########################");
    }
    @RequestMapping(value="/index")
    public String handle(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
        req.setAttribute("servlet", "Servlet");
        return "index";
    }
}
