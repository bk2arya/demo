/*package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//we can interact with a DATABASE to fetch username and password, here we are setting uname and password in Memory only.
		auth.inMemoryAuthentication()
		.withUser("bk2arya").password("PASSWORD1").roles("USER").and()
		.withUser("rag123").password("PASSWORD2").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			
		http.authorizeRequests()
		
		.antMatchers("/info/**").hasRole("ADMIN")
		.anyRequest()		  //any REST or other endpoint request calls
		//.permitAll()		  //any REST or other endpoint request calls --> would be permitted to access by all the users
		.authenticated() //any REST or other endpoint request calls --> would be permitted to access by only AUTHENTICATED users
		
		.and().httpBasic()
		.and().csrf().disable();
		
		//http.csrf().disable();
		//http.httpBasic();
	
	}
}
*/