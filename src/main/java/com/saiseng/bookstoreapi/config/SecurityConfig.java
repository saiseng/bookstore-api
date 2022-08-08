package com.saiseng.bookstoreapi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
	// ref https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated())
				.httpBasic(withDefaults());
		return http.build();
		// check for role for /book/delete
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/book/add", "/book/update", "/book/find-by-author", "/book/find-by-title", "/book/find-all","/swagger-ui/**","/v3/**");
	}
}
