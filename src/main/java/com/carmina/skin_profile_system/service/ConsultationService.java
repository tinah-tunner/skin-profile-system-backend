package com.carmina.skin_profile_system.service;

import com.carmina.skin_profile_system.entity.Consultation;
import com.carmina.skin_profile_system.repository.ConsultationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConsultationService {

    private final ConsultationRepository repo;
private final NotificationService notificationService;

public ConsultationService(
        ConsultationRepository repo,
        NotificationService notificationService
) {
    this.repo = repo;
    this.notificationService = notificationService;
}
  
  public Consultation create(Consultation c) {

    Consultation consultation = repo.save(c);

    notificationService.create(
            "Consultation",
            "Consultation saved successfully."
    );

    return consultation;
}

    public List<Consultation> getAll() {
        return repo.findAll();
    }

    public Consultation getById(Long id) {
        return repo.findById(id).orElse(null);
    }

  public Consultation update(Long id, Consultation c) {

    c.setId(id);

    Consultation consultation = repo.save(c);

    notificationService.create(
            "Consultation",
            "Consultation updated successfully."
    );

    return consultation;
}

   public void delete(Long id) {

    notificationService.create(
            "Consultation",
            "A consultation has been deleted."
    );

    repo.deleteById(id);
}
    // FILTER METHODS

    public List<Consultation> byClient(Long clientId) {
        return repo.findByClientId(clientId);
    }

    public List<Consultation> byTherapist(Long therapistId) {
        return repo.findByTherapistId(therapistId);
    }

    public List<Consultation> bySkinConcern(String concern) {
        return repo.findBySkinConcern(concern);
    }

    public List<Consultation> byTreatmentType(String type) {
        return repo.findByTreatmentType(type);
    }

    public List<Consultation> byDateRange(LocalDate start, LocalDate end) {
        return repo.findByConsultationDateBetween(start, end);
    }

}