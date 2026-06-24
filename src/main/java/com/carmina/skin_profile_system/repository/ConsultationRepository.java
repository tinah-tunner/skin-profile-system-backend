package com.carmina.skin_profile_system.repository;

import com.carmina.skin_profile_system.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByClientId(Long clientId);

    List<Consultation> findByTherapistId(Long therapistId);

    List<Consultation> findBySkinConcern(String skinConcern);

    List<Consultation> findByTreatmentType(String treatmentType);

    List<Consultation> findByConsultationDateBetween(LocalDate start, LocalDate end);
}