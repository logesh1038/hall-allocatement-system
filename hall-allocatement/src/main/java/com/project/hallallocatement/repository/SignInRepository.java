package com.project.hallallocatement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hallallocatement.entity.SignIn;

public interface SignInRepository extends JpaRepository<SignIn, String> {

}
