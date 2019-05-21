package com.cos.IotProjectGit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.IotProjectGit.model.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{
	public Applicant findByUsername(String username);
}
