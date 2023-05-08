package com.spring.study.springstudy.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * 独自のアノテーションを実装するためのクラス
 * 
 * @author まさき
 * @version 1.1
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig {
}
