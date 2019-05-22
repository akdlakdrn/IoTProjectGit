package com.cos.IotProjectGit.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicantResume {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	
	//타이틀 선언
	@Column(nullable = false, length = 100)//null값 금지
	private String applicantResumetitle;
	//파일 관리를 위한 객체 선언
	private String mimeType;
	private String fileName;
	private String filePath;
	//희망주소
	private String wishaddress;
	//경력
	private String experience;
	//직종
	private String job;
	//나이
	private String age;
	//희망연봉
	private String salary;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnoreProperties({"username","password","createDate","updateDate"})
	private Applicant applicant;
	
	
	@CreationTimestamp
	private LocalDate createDate;
	@CreationTimestamp
	private LocalDate updateDate;

}
