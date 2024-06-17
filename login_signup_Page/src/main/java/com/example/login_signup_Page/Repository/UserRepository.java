package com.example.login_signup_Page.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login_signup_Page.Entity.UserEntry;





public interface UserRepository extends JpaRepository<UserEntry,Long>{

    public UserEntry findByGmail(String gmail);
}
