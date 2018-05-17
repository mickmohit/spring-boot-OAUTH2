package com.example.demo;

import java.util.Arrays;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.config.CustomUserDetails;
import com.example.demo.config.UserService;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repo.UserRepository;
//@ComponentScan(basePackages = { "com.example.demo" })
@ComponentScan
@SpringBootApplication
@Configuration
@EnableWebSecurity
public class SpringBootOauth2Application {

	/*@Autowired
	private PasswordEncoder passwordEncoder;
	*/
	public static void main(String[] args) {
		SpringApplication.run(SpringBootOauth2Application.class, args);
	}
	
	
	@Bean
    public BCryptPasswordEncoder  getPasswordEncoder() {
       return new BCryptPasswordEncoder();
             
 }
	
/*	@SuppressWarnings("deprecation")
	@Bean  
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
	    return hemf.getSessionFactory();  
	}   */
	
	
	
	/*@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Bean
	public SessionFactory getSessionFactory() {
	    if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
	        throw new NullPointerException("factory is not a hibernate factory");
	    }
	    return entityManagerFactory.unwrap(SessionFactory.class);
	}
	*/
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository user, UserService service) throws Exception
	{
		if(user.count()==0)
			service.save(new User("user","user", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
	
		//user.save(new User("user","user", Arrays.asList(new Role("USER"))));
		
		/*builder.userDetailsService((UserDetailsService) arg0 -> new CustomUserDetails (user.findByUsername(arg0)))
		.passwordEncoder(passwordEncoder);*/
		builder.userDetailsService(userDetailsService(user)).passwordEncoder(getPasswordEncoder());
	}
	private UserDetailsService userDetailsService(final UserRepository repository) {
		return username -> new CustomUserDetails(repository.findByUsername(username));
	}
	
}
