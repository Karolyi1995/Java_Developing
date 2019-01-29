package spring;

import exception.LoginException;
import exception.RegisterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Component
public class SpingLoginImpl extends Exception implements SpringLoginInterface{

    @Autowired
    public Map<String,String> users;

    public void register(String username, String password) throws RegisterException{
        if(users.containsKey(username)){
            throw new RegisterException("User already exists");
        }
        else{
            users.put(username,password);
        }
    }

    public void login(String username, String password, HttpSession session) throws LoginException {
        if(users.containsKey(username) && password.equals(users.get(username))){
            session.setAttribute(SESSIONKEY,username);
        }else{
            throw new LoginException("Invalid username or password");
        }
    }

    public void logout(HttpSession session) {
        session.removeAttribute(SESSIONKEY);
    }

}