package com.project.hallallocatement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hallallocatement.Exception.ExistException;
import com.project.hallallocatement.Exception.MailException;
import com.project.hallallocatement.Exception.PassException;
import com.project.hallallocatement.Exception.setSignException;
import com.project.hallallocatement.dao.SignUpDao;
import com.project.hallallocatement.entity.SignUp;
import com.project.hallallocatement.repository.SignUpRepository;

@Service
public class SignUpService {

    @Autowired
    private SignUpDao sd;

    @Autowired
    private SignUpRepository signUpRepository;

    public String setSign(SignUp su) throws setSignException, MailException, PassException, ExistException {
        if (!su.getemail().contains("@gmail.com")) {
            throw new MailException("Invalid email format");
        } else if (su.getPassword().length() < 8) {
            throw new PassException("Password must be more than eight characters");
        } else if (isEmailExists(su.getemail())) {
            throw new ExistException("Email already exists");
        } else {
            return sd.setSign(su);
        }
    }

    public boolean isEmailExists(String email) {
        return signUpRepository.existsByEmail(email);
    }

    public List<SignUp> getSignUpLog() {
        return sd.getSignUp();
    }
}





