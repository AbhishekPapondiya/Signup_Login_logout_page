package com.example.login_signup_Page.Controller;

import com.example.login_signup_Page.Entity.UserEntry;
import com.example.login_signup_Page.Repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;




//@RestController
@Controller
//@RequestMapping("/user")
public class UserController {

@Autowired
 private UserRepository userRepo;

@Autowired
 private BCryptPasswordEncoder bcp;

 @PostMapping("/signup")
 public String signup(@ModelAttribute UserEntry u, HttpSession session) {
    u.setPassword(bcp.encode(u.getPassword()));
    u.setRole("USER");
     userRepo.save(u);
     session.setAttribute("massage", "User registered successfully.");
     return "redirect:/";
 }
 
 @GetMapping("/")
 public String user(Model model, HttpSession session) {
     String massage = (String) session.getAttribute("massage");
     if (massage != null) {
         model.addAttribute("massage", massage);
         session.removeAttribute("massage");
     }
     return "index"; 
 }
 @GetMapping("/login")
 public String login() {
    
     return "login";
 }
 
 


   
    
}
