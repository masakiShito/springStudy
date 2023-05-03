package com.spring.study.springstudy.web.issue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class IssueForm {

	@NotBlank
	@Size(max = 256)
	private String summary;

	@NotBlank
	@Size(max = 256)
	private String description;

}
