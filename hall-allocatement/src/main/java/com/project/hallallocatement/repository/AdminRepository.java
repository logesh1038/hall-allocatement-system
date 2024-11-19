package com.project.hallallocatement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hallallocatement.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin> findByUsername(String username);

    Admin findByUsernameAndPassword(String username, String password);
}

