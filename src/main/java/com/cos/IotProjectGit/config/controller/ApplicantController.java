package com.cos.IotProjectGit.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.IotProjectGit.model.Applicant;
import com.cos.IotProjectGit.repository.ApplicantRepository;
import com.cos.IotProjectGit.service.ApplicantCustomService;

@Controller
public class ApplicantController {
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@GetMapping("/")
	public String home() {
		return "applicant/applicant";
	}
	
	@GetMapping("/applicant/login")
	public String ApplicantLogin() {
		return"applicant/login";
	}

	@GetMapping("/applicant/join")
	public String ApplicantJoin() {
		return "applicant/join";
	}
	
	@PostMapping("/applicant/create")
	public String create(Applicant applicant) {
		String rawPassword = applicant.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		applicant.setPassword(encPassword);
		applicantRepository.save(applicant);
		return "/applicant/login";
	}

}
