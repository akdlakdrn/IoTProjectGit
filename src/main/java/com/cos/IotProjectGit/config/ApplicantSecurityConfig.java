package com.cos.IotProjectGit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.IotProjectGit.service.ApplicantCustomService;

@Configuration
@EnableWebSecurity
public class ApplicantSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder applicant) throws Exception {
		applicant.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors().disable();
		http.authorizeRequests()
//				.antMatchers("/applicant/**", "/follow/**", "/images/**")
				.antMatchers("/applicant/**").permitAll();//지정할때쓰는거
//				.authenticated()
//				.anyRequest().permitAll();
//				.and()
//				.formLogin()
//				.loginPage("/applicant/login")
//				.loginProcessingUrl("/applicant/loginproc");
			//	.defaultSuccessUrl("/applicant/join");
	}
	

}

