package com.bhl.crm.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity

public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	@Qualifier("dataSourceForUsers")
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder bcpe;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(bcpe);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/","/showProd","/showCat","/search").hasAnyRole("ADMIN","EMPLOYEE","MANAGER")
			.antMatchers("/addFormProd","/addFormCat","/updateFormProd","/deleteProd").hasRole("MANAGER")
			.antMatchers("/showUsers","/updateUser","/deleteUser").hasRole("ADMIN").and()
			.formLogin().loginPage("/showLoginPage").loginProcessingUrl("/authenticatedTheUser").permitAll().and()
			.logout().permitAll().and()
			.exceptionHandling().accessDeniedPage("/accessDenied");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsManager userDetailsManager() {
		JdbcUserDetailsManager detailsManager = new JdbcUserDetailsManager();
		detailsManager.setDataSource(dataSource);
		return detailsManager;
	}
}
