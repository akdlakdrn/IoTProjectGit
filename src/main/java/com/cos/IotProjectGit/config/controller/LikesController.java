package com.cos.IotProjectGit.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cos.IotProjectGit.repository.LikesRepository;
import com.cos.IotProjectGit.service.LikesService;

@Controller
public class LikesController {
	
	@Autowired
	private LikesRepository likeRepository;
	
	@Autowired
	private LikesService likesService;

}
