package az.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user1234")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin4321")
                .roles("ADMIN")
                .and()
                .withUser("librarian")
                .password("librarian1234")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        String adminSecurity = "\"/users/saveBook\",\"/users/deleteBook\",\"/users/updateBook\",\"/users/";
        http.authorizeRequests()
                .antMatchers("/users/saveBook","/users/deleteBook","/users/updateBook","/users/showAllLibrarian","/users/saveLibrarian")
                .hasAnyRole("ADMIN")
                .antMatchers("/users/getAllBook")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().httpBasic()
                .and()
                .formLogin()
                .and()
                .csrf().disable();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
