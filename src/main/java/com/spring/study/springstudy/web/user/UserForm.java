package com.spring.study.springstudy.web.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.spring.study.springstudy.web.validation.UniqueUsername;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserForm {

	@NotBlank
	@UniqueUsername
	private String username;

	@NotBlank
	@Size(min = 12, max = 128)
	private String password;

	@NotBlank
	private String authority;
}
