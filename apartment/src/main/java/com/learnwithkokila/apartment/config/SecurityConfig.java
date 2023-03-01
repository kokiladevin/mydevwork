package com.learnwithkokila.apartment.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
//	
//	  @Autowired
//	  private AppBasicAuthenticationEntryPoint authenticationEntryPoint;
	
	  @Bean
	  public static PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }

	  @Bean
	  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	   
		  http.csrf().disable()
		  	.authorizeHttpRequests((authorize)->authorize.anyRequest().authenticated())
	        .httpBasic(Customizer.withDefaults());
	       
	    return http.build();
	  }
	  
	  @Bean
	  public UserDetailsService userDetailsService()
	  {
		  List<UserDetails> users=new ArrayList<>();
		  users.add(User.builder()
				  			.username("user")
				  			.password(passwordEncoder().encode("user"))
				  			.roles("USER")
				  			.build());
		  
		  users.add(User.builder()
		  					.username("admin")
		  					.password(passwordEncoder().encode("admin"))
		  					.roles("ADMIN")
		  					.build());
		  
		  return new InMemoryUserDetailsManager(users);
	  }

//	  @Bean
//	  public InMemoryUserDetailsManager userDetailsService() {
//	    UserDetails user = User
//	        .withUsername("user")
//	        .password("user")
//	        .roles("ADMIN")
//	        .build();
//	    return new InMemoryUserDetailsManager(user);
//	  }
//
	 

}
