package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.repository.EmailRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmailController {

    EmailRepository er = new EmailRepository();

    @GetMapping ("/singleEmail")
    public String singleEmail(Model model){
        model.addAttribute("allEmails", er.fetchSingleEmail());
        return "emails";
    }

    @GetMapping("/allEmails")
    public String allEmails(Model model){
       model.addAttribute("allEmails", er.fetchAllEmails());
       return "emails";
    }


    @PostMapping("/session")
    public String session(WebRequest request, HttpSession session){
        session.setAttribute("username", request.getParameter(""));
        return "emails";
    }

}
