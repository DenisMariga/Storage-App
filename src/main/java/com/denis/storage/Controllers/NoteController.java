package com.denis.storage.Controllers;

import com.denis.storage.AppServices.NoteService;
import com.denis.storage.Models.Notes;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }
    @PostMapping("/newNote")
    public String newNote(Notes notes, ModelMap model, BindingResult result) {
        try {
            notes.setUsername(getLoggedInUserName(model));
            noteService.save(notes);
            model.addAttribute("success", true);

        } catch (Exception e) {
            model.addAttribute("errorhappens", true);
        }
        return "result";
    }

    @RequestMapping(value = "/updateNote", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Notes notes, ModelMap model) {
        notes.setUsername(getLoggedInUserName(model));
        noteService.save(notes);
        return "redirect:/notes";
    }

    @GetMapping("/delete/{noteid}")
    public String deleteNote(@PathVariable Long noteid) {
        noteService.DeleteNote(noteid);
        return "redirect:/notes";
    }

    @GetMapping("/edit/{noteid}")
    public String editNote(@PathVariable Long noteid, Model model) {
        Notes notes = noteService.getByID(noteid);
        model.addAttribute("notes", notes);
        return "EditNote";
    }

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        String name = getLoggedInUserName(model);
        List<Notes> notesList = noteService.getNotes(name);
        model.addAttribute("notes", notesList);
        // model.put("todos", service.retrieveTodos(name));
        return "notes";
    }

}
