package spring;

import exception.LoginException;
import exception.RegisterException;
import jdk.nashorn.internal.runtime.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    public SpringLoginInterface loginservice;

    @RequestMapping("/handleRegister")
    public String handleRegister(HttpServletRequest req, HttpServletResponse resp){
        try{
            loginservice.register(req.getParameter("username"),req.getParameter("password"));
        }catch(RegisterException err){
            return "RegisterError";
        }
        return "RegisterSuccess";
    }

    @RequestMapping("/Register")
    public String renderRegistration(){
        return "Register";
    }

    @RequestMapping("/handleLogin")
    public String handleLogin(HttpServletRequest req, HttpServletResponse resp){
        try{
            loginservice.login(req.getParameter("username"),req.getParameter("password"),req.getSession());
            System.out.println("Login Successful");
        }catch(LoginException err){
            System.err.println("Login failed: " + err.getMessage());
            return "LoginError";
        }
        return "LoginSuccess";
    }

    @RequestMapping("/Login")
    public String renderLogin(){
        return "Login";
    }

    @RequestMapping("/Logout")
    public String handle(HttpServletRequest req, HttpServletResponse resp) {
        loginservice.logout(req.getSession());
        return "Welcome";
    }
}
