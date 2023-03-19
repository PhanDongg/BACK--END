package mock.project.backend;

<<<<<<< HEAD
import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
=======
>>>>>>> 5325154fe18fd0a673e0d6f5e31a890e3dc110d9
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			
			http
				.authorizeRequests()
					.antMatchers("/", "/login", "/logout", "/home").permitAll();
			http
				.authorizeRequests()
					.antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
//				    .antMatchers("/userInfo").hasAnyAuthority("ROLE_USER","ROLE_ADMIN");
//				    .antMatchers("/userInfo").hasAnyRole("ROLE_USER","ROLE_ADMIN");
			http
				.authorizeRequests()
					.antMatchers("/user/**", "/register-user").access("hasRole('ROLE_ADMIN')");
			http
				.authorizeRequests()
					.and().exceptionHandling().accessDeniedPage("/403");
			http
				.authorizeRequests()
					.and().formLogin()
					.loginProcessingUrl("/j_spring_security_check")
					.loginPage("/login")
					.defaultSuccessUrl("/homePage")
					.failureUrl("/login?error=true")
					.usernameParameter("username")
					.passwordParameter("password")
					
					.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
					.and()
		            .sessionManagement()
		                .sessionFixation().newSession()
		                .maximumSessions(1)
		                .maxSessionsPreventsLogin(true)
		                .expiredUrl("/login?expired")
		                .and()
		                .invalidSessionUrl("/login?invalid")
		                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
=======
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
>>>>>>> 5325154fe18fd0a673e0d6f5e31a890e3dc110d9

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
        	.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

<<<<<<< HEAD
		}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
	
=======
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
>>>>>>> 5325154fe18fd0a673e0d6f5e31a890e3dc110d9
}
