package com.cos.IotProjectGit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.IotProjectGit.model.ApplicantResume;

public interface ResumeRepository extends JpaRepository<ApplicantResume, Integer>{

}
