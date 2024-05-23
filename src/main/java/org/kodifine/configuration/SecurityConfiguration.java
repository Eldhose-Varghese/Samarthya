package org.kodifine.configuration;

import java.rmi.registry.Registry;

import org.kodifine.Repository.MyUserRepository;
import org.kodifine.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private MyUserDetailsService mydetails;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpsecurity) throws Exception
	{
		
		return httpsecurity
				.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable() )
				.authorizeHttpRequests(registry->{
			registry.requestMatchers("/login","/register/**").permitAll();
			registry.requestMatchers("/senior/**").hasRole("SENIOR");
			registry.requestMatchers("/training/**").hasRole("TRAINING");
			registry.requestMatchers("/hr/**").hasRole("HR");
			registry.requestMatchers("/appraisal/**").hasRole("APPRAISAL");
			registry.requestMatchers("/employee/**").hasRole("EMPLOYEE");
			registry.anyRequest().authenticated();
			
		}
				)
				.formLogin(formLogin->formLogin.permitAll())
				.build();
		
	}
	
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		UserDetails employeeuser = User.builder()
//							.username("eu")
//							.password("$2a$12$swvHvZlZq1g3pQdqCfvx/.iKJCqGWbrBa6fQ5BV4En2o39oTHKucm")
//							.roles("EMPLOYEE")
//							.build();
//		UserDetails hruser = User.builder()
//				.username("hu")
//				.password("$2a$12$mHBVdsDg8RKeyuEf.f157etuqriykkyWOMgEudeDEhvur0ECZBFHa")
//				.roles("EMPLOYEE","HR")
//				.build();
//		return new InMemoryUserDetailsManager(employeeuser,hruser);
//	}
//	
	@Bean
	public UserDetailsService userDetailsService()
	{
			return mydetails;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(mydetails);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
