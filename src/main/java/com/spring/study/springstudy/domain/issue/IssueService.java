package com.spring.study.springstudy.domain.issue;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueService {

	private final IssueRepository issueRepository;

	public List<IssueEntity> findAll() {
		return issueRepository.findAll();
	}

	@Transactional
	public void create(String summary, String description) {
		issueRepository.insert(summary, description);
	}

	public IssueEntity findById(long issueId) {
		return issueRepository.findById(issueId);
	}
}
