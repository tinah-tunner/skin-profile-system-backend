package com.carmina.skin_profile_system.controller;

import com.carmina.skin_profile_system.entity.Booking;
import com.carmina.skin_profile_system.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking create(@RequestBody Booking b) {
        return service.create(b);
    }

    @GetMapping
    public List<Booking> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}/status")
    public Booking updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}