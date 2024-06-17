package com.example.login_signup_Page.Configuration;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.login_signup_Page.Entity.UserEntry;

public class UserConfig implements UserDetails {

    private UserEntry userEntry;

    public UserConfig(UserEntry uEntry){
        super();
        this.userEntry=uEntry;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(userEntry.getRole()));
    }

    @Override
    public String getPassword() {
       
        return userEntry.getPassword();
    }

    @Override
    public String getUsername() {
        
        return userEntry.getGmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
