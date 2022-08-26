package com.denis.storage.Controllers;


import com.denis.storage.AppServices.UserService;
import com.denis.storage.Models.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping("/addNew")
    public String addNew(@Valid Users users, RedirectAttributes redirect) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        service.save(users);
        redirect.addFlashAttribute("message", "You successfully signed up! Please login ");

        return "redirect:/login";
    }
}
