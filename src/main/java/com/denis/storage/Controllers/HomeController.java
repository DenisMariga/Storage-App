//package com.denis.storage.Controllers;
//
//import com.denis.storage.AppServices.CredentialsService;
//import com.denis.storage.AppServices.NoteService;
//import com.denis.storage.AppServices.UserService;
//import com.denis.storage.Models.Credential;
//import com.denis.storage.Models.Notes;
//import com.denis.storage.Models.Users;
//import org.dom4j.rule.Mode;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/")
//public class HomeController {
//    private final CredentialsService credentialsService;
//    private final NoteService noteService;
//    private final UserService userService;
//
//    public HomeController(CredentialsService credentialsService, NoteService noteService, UserService userService) {
//        this.credentialsService = credentialsService;
//        this.noteService = noteService;
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public String home(Authentication authentication, Model model) {
//        model.addAttribute("credential", new Credential());
//        model.addAttribute("notes", new Notes());
//        String username = authentication.getName();
//        Long userId = userService.getUserByUsername(username).getUserid();
////model.addAttribute("notes",noteService.)
//        //find notes by userId
//        return "home";
//    }
//}
