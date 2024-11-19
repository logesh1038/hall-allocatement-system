package com.project.hallallocatement.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hallallocatement.entity.Register;

public interface RegisterRepository extends JpaRepository<Register, Long> {
    List<Register> findBookingsByBlockAndRoomAndCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqualAndCheckInTimeLessThanEqualAndCheckOutTimeGreaterThanEqual(
            String block, String room, String string2, String string, String string4, String string3);

    
}


