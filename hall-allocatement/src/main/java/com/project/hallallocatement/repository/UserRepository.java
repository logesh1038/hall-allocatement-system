package com.project.hallallocatement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.hallallocatement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    User findByUsernameNative(String username);
}
