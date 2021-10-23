package tda.springframework.studentapiproject.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    protected void configure(AuthenticationManagerBuilder auth) throws Exception 
    {
        auth.inMemoryAuthentication()
                .passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
                .withUser("admin")
                .password("admin")
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password("user")
                .roles("USER");
    } 
    
    protected void configure(HttpSecurity http) throws Exception 
    {
        http.httpBasic().and().authorizeRequests()         
                .antMatchers("/").hasAnyRole("ADMIN","USER")
                .antMatchers("/{id}").hasAnyRole("ADMIN","USER")
                .antMatchers("/byname/{name}").hasAnyRole("ADMIN","USER")
                .antMatchers("/byemail/{name}/{email}").hasAnyRole("ADMIN","USER")
                .antMatchers("/add").hasRole("ADMIN")
                .antMatchers("/update/{id}").hasRole("ADMIN")
                .antMatchers("/delete/{id}").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().csrf().disable().formLogin();
    }  
}