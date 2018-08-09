package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic();
		http.authorizeRequests().antMatchers("/api/users/**").hasAnyRole("ADMIN", "USER");
		http.authorizeRequests().antMatchers("/api/admin/**").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
		http.csrf().disable();
	}


	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("guest").password("{noop}pass@123").roles("USER").build();

		// .password("{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG").roles("USER").build();

		UserDetails admin = User.withUsername("akanksha").password("{noop}pass@123").roles("ADMIN").build();

		return new InMemoryUserDetailsManager(user, admin);
	}
}