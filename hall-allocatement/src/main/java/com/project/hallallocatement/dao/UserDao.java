package com.project.hallallocatement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.hallallocatement.entity.User;
import com.project.hallallocatement.repository.UserRepository;

public class UserDao {
    @Autowired
    UserRepository userrepo;
    public String user(User signEntry) {
		System.out.println(signEntry.getLoginAttempts());
		userrepo.save(signEntry);
		return "Valid Person";
	}
    public List<User>getLoginAttempts(){
        return userrepo.findAll();
    }
    
}
