package com.denis.storage.Controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class global {
    public String timout(HttpSession session){
        session.setMaxInactiveInterval(2);

return "login";
    }
}
