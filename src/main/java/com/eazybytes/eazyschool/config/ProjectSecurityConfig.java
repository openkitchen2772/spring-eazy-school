package com.eazybytes.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll()
//                .and().formLogin()
//                .and().httpBasic();

          http.csrf().disable().authorizeRequests()
                  .mvcMatchers("/dashboard").authenticated()
                  .mvcMatchers("/home").permitAll()
                  .mvcMatchers("/holidays/**").permitAll()
                  .mvcMatchers("/contact").permitAll()
                  .mvcMatchers("/saveMsg").permitAll()
                  .mvcMatchers("/courses").permitAll()
                  .mvcMatchers("/about").permitAll()
                  .mvcMatchers("/login").permitAll()
                  .and().formLogin()
                        .loginPage("/login").defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                        .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                  .and().httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User.builder().passwordEncoder(passwordEncoder::encode)
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        UserDetails admin = User.builder().passwordEncoder(passwordEncoder::encode)
                .username("admin")
                .password("admin")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

}
