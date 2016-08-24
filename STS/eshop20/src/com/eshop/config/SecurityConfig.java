package com.eshop.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.eshop")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {	
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select login, password, enabled from users where login=?")
				.authoritiesByUsernameQuery("select login, role from users where login=?");		
	}

	@Override	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/**", "/login", "/main", "/register", "/loginpage", "/resources/**", "/logout", "/registration", "/adduser", "/cart/**")		
		.permitAll()
		.antMatchers("/admin/**").access("hasRole('ADMIN')")
		.antMatchers("/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
		.anyRequest().authenticated()
		.and()
		.formLogin()	
		.loginPage("/main")
		.loginProcessingUrl("/j_spring_security_check")			
		.failureUrl("/main?login_error=t")
		.defaultSuccessUrl("/").usernameParameter("login").passwordParameter("password")	
		.and()
		.logout()
	    .logoutSuccessUrl("/")
		.logoutUrl("/logout")		
		.and().csrf().disable();
	}
}
