package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repo.UserRepository;
@Service
public class UserService extends WebSecurityConfigurerAdapter {
	 @Autowired
	    private UserRepository repo;
	 
	 @Autowired
	 private BCryptPasswordEncoder  passwordEncoder;
	 
	 
	 public void save(User user){
	      // user.setPassword(getPasswordEncoder().encode(user.getPassword()));
		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		 // user.setPassword(user.getPassword());
		 repo.save(user);
	    }
	 
	/* @Bean  
	 public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
	     return hemf.getSessionFactory();  
	 }  
	 @Autowired
	 private SessionFactory sessionFactory;
	 */
	   
	 @Bean
		@Override
	    public AuthenticationManager authenticationManager() throws Exception {
	       
	        return super.authenticationManager();
	    }
}
