package com.spring.study.springstudy.domain.auth;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * ユーザサービスクラス
 * 
 * <p>ユーザ表示などの処理を行う。
 * <p>管理者権限を持っていないユーザについては、一覧の表示および、新規ユーザの登録はできない。
 * 
 * @author まさき
 * @version 1.1
 */

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	/**
	 * ユーザ一覧取得処理
	 * <p>ユーザ情報を取得し、リストを返却する。
	 * @return ユーザ一覧リスト
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/**
	 * ユーザ登録処理
	 * <p>パラメータでもらった情報を元にユーザ情報を登録する。
	 * @param username
	 * @param password
	 * @param authority
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	public void create(String username, String password, String authority) {

		var encodedPassword = passwordEncoder.encode(password);
		userRepository.insert(username, encodedPassword, authority);
	}
}
