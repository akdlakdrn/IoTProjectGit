package com.cos.IotProjectGit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.IotProjectGit.model.CompanyResume;

public interface StaffingRepository extends JpaRepository<CompanyResume, Integer>{

}
