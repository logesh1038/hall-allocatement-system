package com.project.hallallocatement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hallallocatement.entity.SignUp;


public interface SignUpRepository extends JpaRepository<SignUp, Integer> {
    boolean existsByEmail(String email);
}
