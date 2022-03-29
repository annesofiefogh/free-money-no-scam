package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class IndexController {

    private ValidateEmailService ves = new ValidateEmailService();

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/success")
    public String success(){
        return "success";
    }

    @GetMapping("/failure")
    public String failure(){
        return "failure";
    }

    @PostMapping("/test")
    public String test(WebRequest dataFromForm){
        if (ves.isEmailValid(dataFromForm.getParameter("email"))){
            return "redirect:/success";
        } else {
            return "redirect:/failure";
        }
    }

    @GetMapping("/viewAllEmails")
    public String listOfAllEmails(Model model){
        return "emails";
    }
}
