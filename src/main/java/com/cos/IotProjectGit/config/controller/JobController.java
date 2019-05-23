package com.cos.IotProjectGit.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cos.IotProjectGit.repository.JobRepository;
import com.cos.IotProjectGit.service.JobService;

@Controller
public class JobController {
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private JobService jobService;

}
