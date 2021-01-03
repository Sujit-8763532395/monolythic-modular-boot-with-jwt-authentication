package com.aashdit.wcd.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.aashdit.wcd.web.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        		.antMatchers("/restapi/web/userLogin").permitAll()
        		.antMatchers("/restapi/web/get-loggedin-user-details").authenticated()
        		.antMatchers("/restapi/common/").hasRole("ADMIN") //Welcome URL Of Common Service 
        		.antMatchers("/restapi/recruitment/").hasRole("ADMIN") //Welcome URL Of Recruitment Service 
        		.antMatchers("/restapi/user/").hasRole("ADMIN") //Welcome URL Of User Service 
        		.antMatchers("/restapi/common/location/**").permitAll()
        		.antMatchers("/restapi/user/getRoleList").permitAll()
        		/*User Module Specific*/ 
        		.antMatchers("/restapi/user/signUpUser").permitAll()
        		.antMatchers("/restapi/user/userList").hasRole("ADMIN")
        		.antMatchers("/restapi/user/viewProfile").authenticated()
        		.antMatchers("/restapi/user/updateProfile").authenticated()
        		.antMatchers("/restapi/user/changePassword").authenticated()
        		.antMatchers("/restapi/user/requestForResetPassword").permitAll()
        		.antMatchers("/restapi/user/submitOtpForResetPassword").permitAll()
        		.antMatchers("/restapi/user/resetPassword").permitAll()
        		//.anyRequest().authenticated()
                .and().exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                                   "/configuration/ui",
                                   "/swagger-resources/**",
                                   "/configuration/security",
                                   "/swagger-ui.html",
                                   "/webjars/**");
    }
    
}
	