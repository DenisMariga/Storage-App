package com.denis.storage.Controllers;

import com.denis.storage.AppServices.CredentialsService;
import com.denis.storage.Models.Credential;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.Callable;


@Controller
public class CredentialController {
    private final CredentialsService credentialsService;

    public CredentialController(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    @GetMapping("/credentials")
    public String newNote(Model model) {
        List<Credential> credentialList = credentialsService.getAll();
        model.addAttribute("credentials", credentialList);
        return "credentials";
    }

    @PostMapping("/newCredential")
    public Callable<String> newCredential(Credential credential) {
        return ()->{
            Thread.sleep(3000);
            credentialsService.save(credential);
            return "redirect:/credentials";
        };

    }

    @GetMapping("/deleteCredential/{credentialid}")
    public Callable<String> delete(@PathVariable Long credentialid) {
        return ()->{
            Thread.sleep(3000);
            credentialsService.deleteCredential(credentialid);
            return "redirect:/credentials";
        };

    }

    @GetMapping("/editCredential/{credentialid}")
    public String editCredential(@PathVariable Long credentialid, Model model) {
        Credential credential = credentialsService.getById(credentialid);
        model.addAttribute("credential", credential);
        return "/editCredential";
    }

    @RequestMapping(value = "/updateCredential", method = {RequestMethod.PUT, RequestMethod.GET})
    public Callable<String> update(Credential credential, HttpServletRequest request) {
        System.out.println("Async supported in application :" + request.isAsyncSupported());

        System.out.println("Thread from Spring mvc task executor:" + Thread.currentThread().getName());
        return ()->{
            Thread.sleep(4000);
            System.out.println("In update");
            System.out.println("Thread from Spring mvc task executor:" + Thread.currentThread().getName());

            credentialsService.save(credential);
            return "redirect:/credentials";
        };

    }

}

