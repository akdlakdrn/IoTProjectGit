package com.cos.IotProjectGit.config.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.IotProjectGit.model.Applicant;
import com.cos.IotProjectGit.repository.ApplicantRepository;
import com.cos.IotProjectGit.service.ApplicantCustomService;

@Controller
public class ApplicantController {
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Autowired
	private ApplicantCustomService applicantCustomService;
	
	@GetMapping("/")
	public String home() {
		return "index";
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
	
	@GetMapping("/{num}")
	public String applicantDetail(@PathVariable int num, Model model) {
		Optional<Applicant> temp = applicantCustomService.applicantDetail(num);
		//숙제 널처리하기(Optional)
		//ispresent()
		
		if(temp.isPresent()) {
			Applicant applicant = temp.get();
			model.addAttribute("applicant",applicant);
			System.out.println("applicantupdate");
			return "applicantupdate";
		}else {
			System.out.println("applicantupdateerror");
			return "applicantupdateerror";
		}

}
}
