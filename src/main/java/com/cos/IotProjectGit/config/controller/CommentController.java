package com.cos.IotProjectGit.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cos.IotProjectGit.repository.CommentRepository;
import com.cos.IotProjectGit.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private CommentService commentService;
}
