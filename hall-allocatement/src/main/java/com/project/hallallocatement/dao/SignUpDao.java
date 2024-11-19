package com.project.hallallocatement.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hallallocatement.entity.SignUp;
import com.project.hallallocatement.repository.SignUpRepository;


@Repository
public class SignUpDao {
	
	@Autowired
	SignUpRepository sur;

	
	public String setSign(SignUp su) { if (su == null) {
        return "SignUp object is null";
    }
    
    try {
        // Save the SignUp object using the repository
        sur.save(su);
        return "Successfully signed up";
    } catch (Exception e) {
        // Handle any exceptions that may occur during the saving process
        return "Error occurred during signup: " + e.getMessage();
    }
	}
	public List<SignUp>getSignUp(){
		return sur.findAll();

	}
}
