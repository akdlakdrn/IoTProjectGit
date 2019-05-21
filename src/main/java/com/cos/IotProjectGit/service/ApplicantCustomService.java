package com.cos.IotProjectGit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.IotProjectGit.model.Applicant;
import com.cos.IotProjectGit.repository.ApplicantRepository;


@Service
public class ApplicantCustomService implements UserDetailsService{
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
//	public Applicant create(Applicant applicant) {
//		return applicantRepository.save(applicant);
//	}
//	
//	public List<Applicant> findAll(){
//		return applicantRepository.findAll();
//	}
//	
	public Optional<Applicant> findById(int num){
		return applicantRepository.findById(num);
	}
//	
//	public int delete(int num) {
////		boardRepository.delete(entity);
//		try {
//			applicantRepository.deleteById(num);
//			return 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return -1;
//		}
//	}
//	
	public Optional<Applicant> applicantDetail(int num) {
		return applicantRepository.findById(num);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Applicant applicant = applicantRepository.findByUsername(username);
		
		ApplicantCustomerDetail userDetails = null;
		if(applicant != null) {
			userDetails = new ApplicantCustomerDetail();
			userDetails.setApplicant(applicant);
		}else {
			throw new UsernameNotFoundException("유저를 찾을 수 없습니다. "+username);
		}
		return userDetails;
	}



}
