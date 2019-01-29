package spring;

import exception.LoginException;
import exception.RegisterException;

import javax.servlet.http.HttpSession;

public interface SpringLoginInterface {

    String SESSIONKEY = "key";

    void register(String username,String password) throws RegisterException;
    void login(String username, String password,HttpSession sess) throws LoginException;
    void logout(HttpSession sess);
}
