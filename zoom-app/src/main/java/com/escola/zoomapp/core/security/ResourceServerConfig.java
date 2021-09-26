package com.escola.zoomapp.core.security;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
         .antMatchers(HttpMethod.POST, "/usuarios").permitAll()
         .anyRequest().authenticated()
			.and()
				.cors()
			.and()
				.oauth2ResourceServer()
				.jwt();
	}
	
	@Bean
	public JwtDecoder jwtDecoder() {
		var secretKey = new SecretKeySpec("3LHu69615NTYpVLOYiGV18cMEjaFqP3e7B-9PT.m0l2zVB9oIb11m4bjgiys6ImDx-GS5pi22mzFqHm3tcggSuBTye5VHfgN29cwrCv24Lub0nVp2cpRDTZQP-iDOfGg".getBytes(), "HmacSHA256");
		
		return NimbusJwtDecoder.withSecretKey(secretKey).build();
	}
	
}