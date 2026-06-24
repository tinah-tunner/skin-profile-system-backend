package com.carmina.skin_profile_system.controller;

import com.carmina.skin_profile_system.entity.Consultation;
import com.carmina.skin_profile_system.service.ConsultationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/consultations")
@CrossOrigin
public class ConsultationController {

    private final ConsultationService service;

    public ConsultationController(ConsultationService service) {
        this.service = service;
    }

    @PostMapping
    public Consultation create(@RequestBody Consultation c) {
        return service.create(c);
    }

    @GetMapping
    public List<Consultation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Consultation getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Consultation update(@PathVariable Long id, @RequestBody Consultation c) {
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // FILTER ENDPOINTS

    @GetMapping("/client/{clientId}")
    public List<Consultation> byClient(@PathVariable Long clientId) {
        return service.byClient(clientId);
    }

    @GetMapping("/therapist/{therapistId}")
    public List<Consultation> byTherapist(@PathVariable Long therapistId) {
        return service.byTherapist(therapistId);
    }

    @GetMapping("/skin")
    public List<Consultation> bySkin(@RequestParam String concern) {
        return service.bySkinConcern(concern);
    }

    @GetMapping("/treatment")
    public List<Consultation> byTreatment(@RequestParam String type) {
        return service.byTreatmentType(type);
    }

    @GetMapping("/date-range")
    public List<Consultation> byDateRange(
            @RequestParam String start,
            @RequestParam String end
    ) {
        return service.byDateRange(
                LocalDate.parse(start),
                LocalDate.parse(end)
        );
    }
}