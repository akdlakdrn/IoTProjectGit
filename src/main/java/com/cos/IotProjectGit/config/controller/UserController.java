package com.cos.IotProjectGit.config.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.IotProjectGit.model.User;
import com.cos.IotProjectGit.repository.UserRepository;
import com.cos.IotProjectGit.service.UserCustomService;

//Role, Applicant, Company, Admin 
@Controller
public class UserController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository applicantRepository;

	@Autowired
	private UserCustomService applicantCustomService;

	//메인페이지!! (동적:Applicant, Company)
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/user/login")
	public String userLogin() {
		return "user/login";
	}

	@GetMapping("/user/applicant/join")
	public String userApplicantJoin() {
		return "user/applicant/join";
	}
	
	@GetMapping("/user/company/join")
	public String userCompanyJoin() {
		return "user/company/join";
	}

	@PostMapping("/user/create")
	public String userCreate(User user) {
		String rawPassword = user.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		applicantRepository.save(user);
		return "user/login";
	}
	
	//Role만 확인하면 됨!!
	@GetMapping("/user/{id}")
	public String applicantDetail(@PathVariable int id, Model model) {
		Optional<User> temp = applicantCustomService.applicantDetail(id);
		// 숙제 널처리하기(Optional)
		// ispresent()

		if (temp.isPresent()) {
			User user = temp.get();
			model.addAttribute("user", user);
			return "user/detail";
		} else {
			return "error";
		}

	}

}
