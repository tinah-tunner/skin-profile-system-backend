package com.carmina.skin_profile_system.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "consultations")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private Long therapistId;

    private String skinConcern;
    private String treatmentType;

    @Column(length = 3000)
    private String notes;

    @Column(length = 2000)
    private String productRecommendations;

    private String imageUrl;

    private LocalDate consultationDate;

    public Consultation() {}

    public Consultation(Long id, Long clientId, Long therapistId,
                        String skinConcern, String treatmentType,
                        String notes, String productRecommendations,
                        String imageUrl, LocalDate consultationDate) {
        this.id = id;
        this.clientId = clientId;
        this.therapistId = therapistId;
        this.skinConcern = skinConcern;
        this.treatmentType = treatmentType;
        this.notes = notes;
        this.productRecommendations = productRecommendations;
        this.imageUrl = imageUrl;
        this.consultationDate = consultationDate;
    }

    // GETTERS & SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public Long getTherapistId() { return therapistId; }
    public void setTherapistId(Long therapistId) { this.therapistId = therapistId; }

    public String getSkinConcern() { return skinConcern; }
    public void setSkinConcern(String skinConcern) { this.skinConcern = skinConcern; }

    public String getTreatmentType() { return treatmentType; }
    public void setTreatmentType(String treatmentType) { this.treatmentType = treatmentType; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getProductRecommendations() { return productRecommendations; }
    public void setProductRecommendations(String productRecommendations) { this.productRecommendations = productRecommendations; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public LocalDate getConsultationDate() { return consultationDate; }
    public void setConsultationDate(LocalDate consultationDate) { this.consultationDate = consultationDate; }
}