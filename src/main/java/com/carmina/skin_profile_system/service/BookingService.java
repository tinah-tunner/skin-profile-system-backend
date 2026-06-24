package com.carmina.skin_profile_system.service;

import com.carmina.skin_profile_system.entity.Booking;
import com.carmina.skin_profile_system.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository repo;

    public BookingService(BookingRepository repo) {
        this.repo = repo;
    }

    public Booking create(Booking b) {
        return repo.save(b);
    }

    public List<Booking> getAll() {
        return repo.findAll();
    }

    public Booking updateStatus(Long id, String status) {
        Booking b = repo.findById(id).orElseThrow();
        b.setStatus(status);
        return repo.save(b);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}