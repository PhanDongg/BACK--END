package mock.project.backend;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			
			http
				.authorizeRequests()
					.antMatchers("/", "/login", "/logout").permitAll();
			http
				.authorizeRequests()
					.antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
			http
				.authorizeRequests()
					.antMatchers("/user/**", "/register-user").access("hasRole('ROLE_ADMIN')");
			http
				.authorizeRequests()
					.and().exceptionHandling().accessDeniedPage("/403");
			http
				.authorizeRequests()
					.and().formLogin()
	//Submit URL of login page.
					.loginProcessingUrl("/j_spring_security_check")// Submit URL/action form
					.loginPage("/login")//
					.defaultSuccessUrl("/index")//
					.failureUrl("/login?error=true")//
					.usernameParameter("username")//
					.passwordParameter("password")
	//Config for Logout Page
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

	//Config Remember Me.
			http.authorizeRequests().and() //
					.rememberMe().tokenRepository(this.persistentTokenRepository()) //
					.tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

		}
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
}
