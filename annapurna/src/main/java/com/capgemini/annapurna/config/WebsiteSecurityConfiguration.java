package com.capgemini.annapurna.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebsiteSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http.authorizeRequests().antMatchers("/").permitAll()
		 * //.antMatchers("/welcome").hasAnyRole("USER",
		 * "ADMIN").antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN"),
		 * "/foodItems", "/search"
		 * .antMatchers("/cart").hasAnyRole("ADMIN").anyRequest().authenticated().and().
		 * formLogin() .permitAll().and().logout().permitAll();
		 */
		http.authorizeRequests().antMatchers("/", "/foodItems", "/search").permitAll()// .antMatchers("/welcome").hasAnyRole("USER",
																						// "ADMIN")
				.antMatchers("/cart").hasAnyRole("USER", "ADMIN")// .antMatchers("/search").hasAnyRole("ADMIN")
				.anyRequest().authenticated().and().formLogin().permitAll().and().logout().permitAll();

		/*
		 * http.httpBasic().and() .authorizeRequests()
		 * .requestMatchers(EndpointRequest.to("info", "health")).permitAll()
		 * .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("SYSTEM")
		 * .antMatchers("/**").hasRole("USER");
		 */

		http.csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		/*
		 * authenticationMgr.inMemoryAuthentication().withUser("foods").password("foods"
		 * ).authorities("ROLE_USER").and()
		 * .withUser("annapurna").password("annapurna").authorities("ROLE_USER",
		 * "ROLE_ADMIN");
		 */
		/*
		 * authenticationMgr.inMemoryAuthentication().withUser("user").password(
		 * "{noop}password").roles("USER").and()
		 * .withUser("sysuser").password("{noop}password").roles("SYSTEM");
		 */
		authenticationMgr.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("foods")
				.password("foods").roles("USER").and().withUser("annapurna").password("annapurna").roles("ADMIN");
	}

}