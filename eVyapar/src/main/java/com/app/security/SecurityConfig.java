package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("in config");
		http.cors().and().csrf().disable().authorizeRequests()
				.antMatchers("/floor1/office1/**").hasRole("USER").antMatchers("/floor1/office2/**").hasRole("ADMIN")
				.antMatchers("/floor1/**").permitAll().and().formLogin();

	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("auth builder " + auth);
		/*
		 * auth.inMemoryAuthentication().
		 * withUser("rama").password("1234").roles("USER");
		 * auth.inMemoryAuthentication().withUser("shekhar").password("2345").
		 * roles("USER","ADMIN");
		 */
		// PasswordEncoder encoder =
		// PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("rama").password(encoder.encode("1234")).roles("USER").and()
				.withUser("shekhar").password(encoder.encode("2345")).roles("ADMIN","USER");

	}
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}

	
}
