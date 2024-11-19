package com.project.hallallocatement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hallallocatement.Exception.ExistException;
import com.project.hallallocatement.Exception.MailException;
import com.project.hallallocatement.Exception.PassException;
import com.project.hallallocatement.Exception.setSignException;
import com.project.hallallocatement.entity.SignUp;
import com.project.hallallocatement.service.SignUpService;




@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/signup")
public class SignUpController {
	
	@Autowired
	SignUpService sus;
	
	
	@PostMapping("/index")
public String setSign(@RequestBody SignUp su) throws setSignException, MailException, PassException, ExistException{   

     System.out.println(su.getemail() + " " + su.getPassword());
        return sus.setSign(su);
    }
	
    @GetMapping("/getSignUpLog")
	public List<SignUp> getSignLog() {
		return sus.getSignUpLog();
	}
}
