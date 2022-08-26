package com.denis.storage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.concurrent.Callable;

@Controller
public class ApplicationController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/logou")
    public Callable<String> logout(HttpSession session) {
        return ()->{
            Thread.sleep(3000);
            session.invalidate();
            return "login";
        };

    }
    @GetMapping("/register")
    public String signup() {
        return "signup";
    }

    @GetMapping("results")
    public String result() {
        return "result";
    }


    @GetMapping("/addNote")
    public String addNote() {
        return "NewNote";
    }

    @GetMapping("/addCredential")
    public String addCredential() {
        return "NewCredential";
    }

}

