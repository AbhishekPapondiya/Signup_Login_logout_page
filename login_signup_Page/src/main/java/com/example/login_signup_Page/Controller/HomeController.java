package com.example.login_signup_Page.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.login_signup_Page.Entity.UserEntry;
import com.example.login_signup_Page.Repository.UserRepository;


@Controller
@RequestMapping("/user")
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/home")
    public String home(Principal p,Model model) {

        String name=p.getName();

        UserEntry userEntry=userRepository.findByGmail(name);
        model.addAttribute("name", userEntry.getName());
        return "home";
    }
    
}
