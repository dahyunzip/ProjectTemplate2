package com.itwillbs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserDetailsService customUserDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder());
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
	        .antMatchers("/login", "/signup", "/resources/**").permitAll()
	        .antMatchers("/admin/**").hasRole("ADMIN")
	        .anyRequest().authenticated()

		    .and()
		        .formLogin()
		        .loginPage("/login")
		        .loginProcessingUrl("/login")
		        .defaultSuccessUrl("/")
		        .permitAll()
		
		    .and()
		        .logout()
		        .logoutUrl("/logout")
		        .logoutSuccessUrl("/login?logout")
		        .invalidateHttpSession(true)
		        .deleteCookies("JSESSIONID")
		
		    .and()
		        .exceptionHandling()
		        .accessDeniedPage("/accessDenied")
		
		    .and()
		        .csrf().disable()
				.requestCache().disable();
	}
}
