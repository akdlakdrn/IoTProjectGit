package com.cos.IotProjectGit.config.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cos.IotProjectGit.model.Applicant;
import com.cos.IotProjectGit.model.ApplicantResume;
import com.cos.IotProjectGit.repository.ApplicantResumeRepository;
import com.cos.IotProjectGit.service.ApplicantCustomerDetail;
import com.cos.IotProjectGit.util.ApplicantUtil;

@Controller
public class ApplicantResumeController {

	@Autowired
	private ApplicantResumeRepository applicantResumeRepository;

	@GetMapping("/resume")
	public String resume() {
		return "resume";
	}
	
	@GetMapping("/resume/Detail")
	public String resumeDetail() {
		return "/resume/Detail";
	}

	@PostMapping("/resume/create")
	public @ResponseBody ApplicantResume resumeCreate(@AuthenticationPrincipal ApplicantCustomerDetail applicantDetail,
			@RequestParam("file") MultipartFile file, String applicantResumetitle, String education , String wishaddress, String job,String age,String salary,String experience) throws IOException {
		Path filePath = Paths.get(ApplicantUtil.getResouecePath() + file.getOriginalFilename());
		System.out.println(file.getBytes());
		Files.write(filePath,file.getBytes());
		System.out.println(applicantDetail.getApplicant());
		Applicant applicant = applicantDetail.getApplicant();
		
		ApplicantResume applicantresume = ApplicantResume.builder().applicantResumetitle(applicantResumetitle).
				applicant(applicant).job(job).age(age).salary(salary).
				experience(experience).wishaddress(wishaddress).mimeType(file.getContentType())
				.fileName(file.getOriginalFilename()).filePath("/image/"+file.getOriginalFilename()).build();
		
		applicantResumeRepository.save(applicantresume);
		
		return applicantresume; 
	}

}
