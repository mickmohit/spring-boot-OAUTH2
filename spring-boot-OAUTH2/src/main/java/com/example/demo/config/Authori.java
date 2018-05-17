package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Authori {// extends WebSecurityConfigurerAdapter {

	/*@Bean
	@Override
	  public AuthenticationManager authenticationManager() throws Exception {
	      return super.authenticationManager();
	  }*/
		
	/*@Bean
	@Override
    public AuthenticationManager authenticationManager() throws Exception {
        //final AuthorizationServerConfig oAuth2AuthenticationManager = new AuthorizationServerConfig();
        //oAuth2AuthenticationManager.setTokenServices(defaultTokenServices());
        return super.authenticationManager();
    }*/
	
	/*@Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }*/
}
