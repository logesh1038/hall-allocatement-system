
package com.project.hallallocatement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hallallocatement.entity.Register;
import com.project.hallallocatement.service.RegisterService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register/book-hall")
    public ResponseEntity<String> bookHall(@RequestBody Register register) {
        String message = registerService.bookHall(register);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping("/admin/booking-requests")
    public ResponseEntity<List<Register>> getAllBookings() {
        List<Register> bookings = registerService.getAllBookingRequests();
        return ResponseEntity.ok(bookings);
    }

    @PostMapping("/admin/booking/{id}/approve")
    public ResponseEntity<String> approveBooking(@PathVariable Long id) {
        System.out.println("id"+id);
        String message = registerService.updateBookingStatus(id, "Accepted");
        return ResponseEntity.ok(message);
    }

    @PostMapping("/admin/booking/{id}/reject")
    public ResponseEntity<String> rejectBooking(@PathVariable Long id) {
        String message = registerService.updateBookingStatus(id, "Rejected");
        return ResponseEntity.ok(message);
    }
    
}