package fr.projectdescartes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import fr.projectdescartes.security.RestAuthenticationSuccessHandler;


@Configuration
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	    private UserDetailsService customUserDetailsService;
	    
	    @Autowired
	    private RestAuthenticationSuccessHandler authenticationSuccessHandler;
	    
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) 
	        throws Exception 
	    {
	        auth
	            .userDetailsService(customUserDetailsService)
	            .passwordEncoder(passwordEncoder());
	    }
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http
	    		.csrf().disable()
		    	
		        .authorizeRequests()
			        .antMatchers("/gestionOeuvresNumeriques/","/gestionOeuvresNumeriques/login").permitAll()
			        .antMatchers("/gestionOeuvresNumeriques/admin/**").access("hasRole('ROLE_ADMIN')")
			        .and()
	        
	            .exceptionHandling()
	            	.authenticationEntryPoint(new Http401AuthenticationEntryPoint("Basic realm=\"gestionOeuvresNumeriques\""))
	            	.and()
	            	
	            .formLogin()
	                .permitAll()
	                .loginPage("/gestionOeuvresNumeriques/login")
	                .successHandler(authenticationSuccessHandler)
	                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
	                .and()
	            .logout()
	                .permitAll()
	                .logoutRequestMatcher(new AntPathRequestMatcher("/gestionOeuvresNumeriques/logout"))
	                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
	             ;
	        
	    }

}
