package com.carmina.skin_profile_system.service;

import com.carmina.skin_profile_system.entity.Therapist;
import com.carmina.skin_profile_system.repository.TherapistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TherapistService {

    private final TherapistRepository repo;

    public TherapistService(TherapistRepository repo) {
        this.repo = repo;
    }

    public Therapist create(Therapist t) {
        return repo.save(t);
    }

    public List<Therapist> getAll() {
        return repo.findAll();
    }

    public Therapist getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Therapist update(Long id, Therapist t) {
        t.setId(id);
        return repo.save(t);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}