package mock.project.backend;

<<<<<<< HEAD
=======
import org.modelmapper.ModelMapper;
>>>>>>> 06603f08a7d3bf016bd69dcec4f47e1fe5ea05a6
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import mock.project.backend.config.JwtAuthenticationEntryPoint;
import mock.project.backend.config.JwtRequestFilter;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

    @Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
<<<<<<< HEAD

=======
>>>>>>> 06603f08a7d3bf016bd69dcec4f47e1fe5ea05a6
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
<<<<<<< HEAD

=======
    
>>>>>>> 06603f08a7d3bf016bd69dcec4f47e1fe5ea05a6
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.csrf().disable();
        http
			.authorizeRequests()
				.antMatchers("/api/authenticate/**","/api/user/**","/api/product/**").permitAll();
		http
			.authorizeRequests().antMatchers("/api/admin/**").access("hasRole('ROLE_ADMIN')");
		http
		.authorizeRequests().antMatchers("/api/order/**").access("hasRole('ROLE_USER','ROLE_ADMIN')");
        http       
        	.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
<<<<<<< HEAD

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
=======
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
>>>>>>> 06603f08a7d3bf016bd69dcec4f47e1fe5ea05a6
