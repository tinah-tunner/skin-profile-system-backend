package com.carmina.skin_profile_system.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "skin_images")
public class SkinImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private ImageType imageType;

    private LocalDateTime uploadDate;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    // Default Constructor
    public SkinImage() {
    }

    // All Arguments Constructor
    public SkinImage(Long id, String imageUrl, ImageType imageType,
                     LocalDateTime uploadDate, Consultation consultation) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
        this.uploadDate = uploadDate;
        this.consultation = consultation;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}