package com.project.hallallocatement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.hallallocatement.entity.Register;
import com.project.hallallocatement.repository.RegisterRepository;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Transactional
    public String bookHall(Register register) {
        register.setStatus("Pending");
        registerRepository.save(register);
        return "Hall booking request submitted. Please wait for admin response.";
    }

    public List<Register> getAllBookingRequests() {
        return registerRepository.findAll();
    }

    @Transactional
    public String updateBookingStatus(Long id, String status) {
        Optional<Register> registerOptional = registerRepository.findById(id);
        if (!registerOptional.isPresent()) {
            return "Booking request not found";
        }
        Register register = registerOptional.get();
        register.setStatus(status);
        registerRepository.save(register);
        return "Booking status updated to " + status;
    }
}
