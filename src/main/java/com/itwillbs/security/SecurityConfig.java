package com.itwillbs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
    private UserDetailsService customUserDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//          .authorizeRequests(authz -> authz
//              .antMatchers("/signup", "/login", "/resources/**").permitAll()
//              .antMatchers("/admin/**").hasRole("ADMIN")
//              .anyRequest().authenticated()
//          )
//          .formLogin(form -> form
//              .loginPage("/login")
//              .loginProcessingUrl("/login")
//              .defaultSuccessUrl("/")
//              .permitAll()
//          )
//          .logout(logout -> logout
//              .logoutUrl("/logout")
//              .logoutSuccessUrl("/login?logout")
//              .invalidateHttpSession(true)
//              .deleteCookies("JSESSIONID")
//          )
//          .userDetailsService(customUserDetailsService)
//          .csrf().disable();  // 프로젝트 요구에 따라
//        return http.build();
//    }
	
	
}
