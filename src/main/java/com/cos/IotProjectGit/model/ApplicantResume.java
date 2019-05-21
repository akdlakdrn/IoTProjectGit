package com.cos.IotProjectGit.model;

import java.time.LocalDate;

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
	private String mimeType;
	private String fileName;
	private String filePath;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnoreProperties({"username","password","createDate","updateDate"})
	private Applicant applicant;
	
	
	@CreationTimestamp
	private LocalDate createDate;
	@CreationTimestamp
	private LocalDate updateDate;

}
