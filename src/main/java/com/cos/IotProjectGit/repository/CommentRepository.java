package com.cos.IotProjectGit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.IotProjectGit.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
