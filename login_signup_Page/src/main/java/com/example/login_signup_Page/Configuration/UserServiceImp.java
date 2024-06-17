package com.example.login_signup_Page.Configuration;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.example.login_signup_Page.Entity.UserEntry;
import com.example.login_signup_Page.Repository.UserRepository;

public class UserServiceImp implements UserDetailsService {
   
    @Autowired
    private UserRepository uRepository;

     @Override
    public UserDetails loadUserByUsername(String gmail) throws UsernameNotFoundException {
    
     
        UserEntry userEntry = uRepository.findByGmail(gmail);
        System.out.println("hello="+userEntry);
        if (userEntry == null) {
            throw new UsernameNotFoundException("No user found with gmail: " + gmail);
        }
        return new UserConfig(userEntry);
    }
   
   
     
    
}
