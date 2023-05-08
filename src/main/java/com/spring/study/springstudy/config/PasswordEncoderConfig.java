package com.spring.study.springstudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * パスワードをハッシュ化するためのクラス
 *  passwordEncoderを呼び出すことでパスワードをハッシュ化している。
 * 
 * @author まさき
 * @version 1.1
 */
@Configuration
public class PasswordEncoderConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		
		// SpringSecurityに内包されているハッシュ化するためのクラス
		return new Pbkdf2PasswordEncoder();
	}
}
