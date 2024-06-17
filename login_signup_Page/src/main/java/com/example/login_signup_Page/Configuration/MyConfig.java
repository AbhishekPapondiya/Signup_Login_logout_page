package com.example.login_signup_Page.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class MyConfig {
    
    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserServiceImp();
    }
    @Bean
    public BCryptPasswordEncoder getPassword(){
        return new BCryptPasswordEncoder(); 
    }
    @Bean
    public DaoAuthenticationProvider daoProvider(){
        DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
        dao.setUserDetailsService(getUserDetailsService());
        dao.setPasswordEncoder(getPassword());
        return dao;
    }
//@SuppressWarnings("deprecation")
@SuppressWarnings("deprecation")
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


    http.authenticationProvider(daoProvider());

    http
            
            .authorizeRequests(authorize ->
                    authorize
                           
                           //.requestMatchers("/user/**").hasRole("USER") // Require ROLE_USER for URLs under /user
                           
                           .requestMatchers("/**").permitAll() // Allow access to all other URLs
                            
            )
            .formLogin(formLogin ->
                    formLogin
                            .loginPage("/login") // Custom login page
                            .loginProcessingUrl("/login") // URL to submit the username and password
                            .defaultSuccessUrl("/user/home", true) // Redirect to /user/home after successful login
                            .failureUrl("/login?error=true") // Redirect to /login with an error message on failure
                            .permitAll()
            )
            .logout(logout ->
                    logout
                            .logoutUrl("/logout")
                            .logoutSuccessUrl("/") // Redirect to homepage after logout
                            .permitAll()
            )
            .csrf(csrf -> csrf.disable()); // Disables CSRF protection, use with caution

       

    return http.build();
}
}
