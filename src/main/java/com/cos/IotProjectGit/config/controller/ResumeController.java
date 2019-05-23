package com.cos.IotProjectGit.config.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cos.IotProjectGit.model.User;
import com.cos.IotProjectGit.model.ApplicantResume;
import com.cos.IotProjectGit.repository.ResumeRepository;
import com.cos.IotProjectGit.service.UserCustomerDetail;
import com.cos.IotProjectGit.service.ResumeService;
import com.cos.IotProjectGit.util.ApplicantUtil;

@Controller
public class ResumeController {

	@Autowired
	private ResumeRepository applicantResumeRepository;
	
	@Autowired
	private ResumeService applicantResumeService;

	@GetMapping("/resume")
	public String resume() {
		return "resume";
	}
	
	@GetMapping("/resume/Detail")
	public String resumeDetail() {
		return "/resume/Detail";
	}
	
	@GetMapping("/app/resume/list")
	public @ResponseBody List<ApplicantResume> testfindAll() {
		List<ApplicantResume > resumelist = applicantResumeService.findAll();
		System.out.println("너왔냐?"+resumelist);
		return resumelist;
	}
	
	@GetMapping("/resume/list")
	public String findAll(Model model) {
		model.addAttribute("applicantresumes", applicantResumeService.findAll());// 현재는 자바객체
		return "applicantResume";
	}

	@PostMapping("/resume/create")
	public @ResponseBody ApplicantResume resumeCreate(@AuthenticationPrincipal UserCustomerDetail applicantDetail,
			@RequestParam("file") MultipartFile file, String applicantResumetitle, String education , String wishaddress, String job,String age,int salary,String experience) throws IOException {
		Path filePath = Paths.get(ApplicantUtil.getResouecePath() + file.getOriginalFilename());
		System.out.println(file.getBytes());
		Files.write(filePath,file.getBytes());
		System.out.println(applicantDetail.getApplicant());
		User applicant = applicantDetail.getApplicant();
		
		ApplicantResume applicantresume = ApplicantResume.builder().title(applicantResumetitle).
				user(applicant).job(job).age(age).salary(salary).
				experience(experience).wishAddress(wishaddress).mimeType(file.getContentType())
				.fileName(file.getOriginalFilename()).filePath("/image/"+file.getOriginalFilename()).build();
		
		applicantResumeRepository.save(applicantresume);
		
		return applicantresume; 
	}

}
