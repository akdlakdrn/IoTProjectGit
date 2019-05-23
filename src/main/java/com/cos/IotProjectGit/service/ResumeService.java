package com.cos.IotProjectGit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.IotProjectGit.model.ApplicantResume;
import com.cos.IotProjectGit.repository.ResumeRepository;

@Service
public class ResumeService {

	@Autowired
	ResumeRepository applicantResumeRepository;

	public List<ApplicantResume> findAll() {	
		return applicantResumeRepository.findAll();
	}
}
