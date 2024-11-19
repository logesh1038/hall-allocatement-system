package com.project.hallallocatement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.hallallocatement.entity.User;
import com.project.hallallocatement.repository.AdminRepository;
import com.project.hallallocatement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    public boolean isAdminExists(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password) != null;
    }

    public boolean isUserExists(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password) != null;
    }

    @Transactional
    public void incrementLoginAttempts(String username) {
        User user = userRepository.findByUsernameNative(username);
        if (user != null) {
            int loginAttempts = user.getLoginAttempts();
            user.setLoginAttempts(loginAttempts + 1);
            userRepository.save(user);
        }
    }
    
}
