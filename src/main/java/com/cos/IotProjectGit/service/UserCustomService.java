package com.cos.IotProjectGit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.IotProjectGit.model.User;
import com.cos.IotProjectGit.repository.UserRepository;


@Service
public class UserCustomService implements UserDetailsService{
	
	@Autowired
	private UserRepository applicantRepository;
	
//	public Applicant create(Applicant applicant) {
//		return applicantRepository.save(applicant);
//	}
//	
//	public List<Applicant> findAll(){
//		return applicantRepository.findAll();
//	}
//	
	public Optional<User> findById(int num){
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
	public Optional<User> applicantDetail(int num) {
		return applicantRepository.findById(num);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User applicant = applicantRepository.findByUsername(username);
		
		UserCustomerDetail userDetails = null;
		if(applicant != null) {
			userDetails = new UserCustomerDetail();
			userDetails.setApplicant(applicant);
		}else {
			throw new UsernameNotFoundException("유저를 찾을 수 없습니다. "+username);
		}
		return userDetails;
	}



}
