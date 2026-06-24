package com.carmina.skin_profile_system.controller;

import com.carmina.skin_profile_system.entity.Therapist;
import com.carmina.skin_profile_system.service.TherapistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/therapists")
@CrossOrigin
public class TherapistController {

    private final TherapistService service;

    public TherapistController(TherapistService service) {
        this.service = service;
    }

    @PostMapping
    public Therapist create(@RequestBody Therapist t) {
        return service.create(t);
    }

    @GetMapping
    public List<Therapist> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Therapist update(@PathVariable Long id, @RequestBody Therapist t) {
        return service.update(id, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}