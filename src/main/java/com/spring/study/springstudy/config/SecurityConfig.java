package com.spring.study.springstudy.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

/**
 * Springのセキュリティを設定するためのクラス
 * 
 * Springの各セキュリティを設定
 * ＜概要＞
 * h2-consoleを確認できるようにするための設定
 * 権限によって遷移を制限するための設定
 * 
 * @author まさき
 * @version 1.1
 */

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/** 
		 * For h2-console
		 * h2DBを使用しているため、DBの状態を確認できるようにURLへの直接リクエストを許可している。
		 * 必要に応じて削除 or コメントアウトを行うこと
		 * */
		http
				.authorizeRequests().antMatchers("/h2-console/**").permitAll()
				.and()
				.csrf().ignoringAntMatchers("/h2-console/**")
				.and()
				.headers().frameOptions().disable();
		/** 
		 * For 権限によって遷移を制限するための設定
		 * ADMIN権限を持っているユーザのみが/users/以下のURLに遷移することができる
		 * */
		http
				.authorizeRequests()
				.mvcMatchers("/users/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login").permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder);
	}
}
