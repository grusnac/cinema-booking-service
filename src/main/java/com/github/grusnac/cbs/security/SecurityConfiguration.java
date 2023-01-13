package com.github.grusnac.cbs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
        .httpBasic()
        .and()
        .authorizeHttpRequests(auth -> auth.requestMatchers("/films").hasRole("USER"))
        .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetails(PasswordEncoder passwordEncoder) {
    final UserDetails john =
        User.withUsername("john.doe@mai.com")
            .password(passwordEncoder.encode("secret"))
            .roles("USER")
            .build();
    final UserDetails joana =
        User.withUsername("joana.doe@mai.com")
            .password(passwordEncoder.encode("secret"))
            .roles("GUEST")
            .build();
    final InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
    userDetailsService.createUser(john);
    return userDetailsService;
  }
}
