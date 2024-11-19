package com.project.hallallocatement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.hallallocatement.entity.Register;
import com.project.hallallocatement.entity.User;
import com.project.hallallocatement.service.RegisterService;
import com.project.hallallocatement.service.UserService;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/users/login")
    public ResponseEntity<String> login(@RequestBody User credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        System.out.println(username + " " + password+" ");

        if (userService.isAdminExists(username, password)) {
            return ResponseEntity.ok("Login successful! (Admin)");
        } else if (userService.isUserExists(username, password)) {
            userService.incrementLoginAttempts(username);
            return ResponseEntity.ok("Login successful! (User)");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
    
    @Autowired
    private RegisterService registerService;

    @GetMapping("/booking-requests")
    public ResponseEntity<List<Register>> getAllBookingRequests() {
        List<Register> bookings = registerService.getAllBookingRequests();
        return ResponseEntity.ok(bookings);
    }

    // Other methods...
}
