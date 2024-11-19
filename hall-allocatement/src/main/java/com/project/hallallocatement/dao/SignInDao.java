package com.project.hallallocatement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hallallocatement.entity.SignIn;
import com.project.hallallocatement.repository.SignInRepository;

@Repository
public class SignInDao {
	
	@Autowired
	SignInRepository signInRepo;

	public String signIn(SignIn signEntry) {
		System.out.println(signEntry.getCount());
		signInRepo.save(signEntry);
		return "Valid Person";
	}

	public List<SignIn> getLogList() {
		return signInRepo.findAll();
	}
	
	
	
}
