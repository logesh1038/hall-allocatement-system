package com.project.hallallocatement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hallallocatement.Exception.InvalidException;
import com.project.hallallocatement.Exception.PassException;
import com.project.hallallocatement.entity.SignIn;
import com.project.hallallocatement.service.SignInService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/signin")
public class SignInController {
    
    @Autowired
	SignInService signInService;
	
	@PostMapping("/login")
	public String signIn(@RequestBody SignIn signEntry ) throws InvalidException, PassException {
		return signInService.signIn(signEntry);
	}
	
	
	@GetMapping("/getLogInList")
	public List<SignIn> getLogList() {
		return signInService.getLogList();
	}
	
}

