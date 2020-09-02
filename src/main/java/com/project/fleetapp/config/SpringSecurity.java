package com.project.fleetapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.AllArgsConstructor;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	
	private final UserDetailsService userDetailsService;
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login", "/register", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/js/**")
		.permitAll()
		.antMatchers("/users/addNew")
		.permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logout").permitAll();
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		
		provider.setPasswordEncoder(passwordEncoder());
		
		return provider;
	}
	
}
