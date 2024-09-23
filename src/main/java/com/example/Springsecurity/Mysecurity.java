package com.example.Springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//AUTHENDICATION

//VISIBLE PASSWORD


//@Configuration
//@EnableWebSecurity
//public class Mysecurity extends WebSecurityConfigurerAdapter{
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("vendhan").password("vendhan@123").roles("student");
//	}
//	@Bean
//	public PasswordEncoder pass() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//}


//USING BCRYPT GENERATOR ONLINE

//@Configuration
//@EnableWebSecurity
//public class Mysecurity extends WebSecurityConfigurerAdapter{
//protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.inMemoryAuthentication().withUser("vendhan").password("$2a$12$XOqNOjEd7taYe4vHs5gjiO24FzQyYOzPHfGU726958WpebCCM4iUO"      
//).roles("student");
//}
// 
//@Bean
//public BCryptPasswordEncoder pass() {
//	return new BCryptPasswordEncoder(12);
//}
//}

@Configuration
@EnableWebSecurity
 class Mysecurity extends WebSecurityConfigurerAdapter{
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("vendhan").password("$2a$12$XOqNOjEd7taYe4vHs5gjiO24FzQyYOzPHfGU726958WpebCCM4iUO").roles("student").and().
		withUser("dhanalakshmi").password("$2a$12$wKFKZKvRRg1wHJIf0Rv7TO8EYOA/h0j9W.SLTWVK1gWk7BWueT4hS").roles("trainer").and().
		withUser("nisha").password("$2a$12$QZIiRwHe0v54BmT7xnw4Tevvgvs6hlN.u11219SJN3xcunRCDxZES").roles("manager");

	}
	
	@Bean
	public BCryptPasswordEncoder pass() {
		return new BCryptPasswordEncoder(12);
	}

	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/manager").hasRole("manager");
		http.authorizeHttpRequests().antMatchers("/trainer").hasAnyRole("manager","trainer");
		http.authorizeHttpRequests().antMatchers("/student").hasAnyRole("manager","trainer","student").and().formLogin();
	}
}





