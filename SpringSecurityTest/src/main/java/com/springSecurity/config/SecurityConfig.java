package com.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.csrf()
		.disable()
		.authorizeHttpRequests()
		.requestMatchers("/home/admin")
		.hasRole("ADMIN_ROLE")
		.requestMatchers("/home/normal")
		.hasRole("NORMAL")
		.requestMatchers("/home/public")
		.permitAll()
		.anyRequest()
		.authenticated().and()
		.formLogin();
		return httpSecurity.build();

	}

	@Bean
	public UserDetailsService userDetailsService() {
		
		//Encode the password with BcryptPasswordEncoders
		
		

		UserDetails normalUser = User.withUsername("shubham").password(passwordEncoder().encode("shubham")).roles("NORMAL").build();
		UserDetails adminUser = User.withUsername("sahil").password(passwordEncoder().encode("sahil")).roles("ADMIN_ROLE").build();
		
		InMemoryUserDetailsManager inMemoryUserDetailsManager 	=new InMemoryUserDetailsManager (normalUser,adminUser);
		
		return inMemoryUserDetailsManager;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
