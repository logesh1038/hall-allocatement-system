package com.project.hallallocatement.controller;

import com.project.hallallocatement.entity.Admin;
import com.project.hallallocatement.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adminService.createAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdmin);
    }

    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
    adminService.deleteAdmin(id);
    return ResponseEntity.noContent().build();
}


}



