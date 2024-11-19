package com.project.hallallocatement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hallallocatement.Exception.InvalidException;
import com.project.hallallocatement.Exception.PassException;
import com.project.hallallocatement.dao.SignInDao;
import com.project.hallallocatement.entity.SignIn;
import com.project.hallallocatement.entity.SignUp;

@Service
public class SignInService {

	@Autowired
	SignInDao signInDao;

	@Autowired
	SignUpService signUpService;

	public String signIn(SignIn signEntry) throws InvalidException, PassException {
		signEntry.setCount(1);
		List<SignUp> signObj = signUpService.getSignUpLog();
		List<SignIn> logObj = getLogList();
		logObj.forEach(x -> System.out.println(x.getEmail() + " " + x.getPassword() + " " + x.getCount()));
		boolean flag = true;
		boolean flag2 = true;

		for (int i = 0; i < signObj.size(); i++) {
			if (signEntry.getEmail().equals(signObj.get(i).getemail())
					&& signEntry.getPassword().equals(signObj.get(i).getPassword())) {
				flag = true;

				for (SignIn si : logObj) {
					if (si.getEmail().equals(signEntry.getEmail())
							&& si.getPassword().equals(signEntry.getPassword())) {
						si.setCount(si.getCount() + 1);
						return signInDao.signIn(si);
					} 
				}
				return signInDao.signIn(signEntry);
			} 
			
			else if((signEntry.getEmail().equals(signObj.get(i).getemail()) && !signEntry.getPassword().equals(signObj.get(i).getPassword()))) {
				flag2 = false;
			}
			
			else {
				flag = false;
			}
		}
		if(flag2 == false) {
			throw new PassException("Incorrect Password");
		}
		if (flag == false) {
			throw new InvalidException("Please Sign Up");
		}
		

		return signInDao.signIn(signEntry);
	}

	public List<SignIn> getLogList() {
		return signInDao.getLogList();
	}

}
