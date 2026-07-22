package com.carmina.skin_profile_system.dto;

import java.time.LocalDateTime;

public class PhotoResponse {

    private Long id;
    private String imageUrl;
    private String photoType;
    private LocalDateTime uploadedAt;

    public PhotoResponse() {
    }

    public PhotoResponse(Long id, String imageUrl, String photoType, LocalDateTime uploadedAt) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.photoType = photoType;
        this.uploadedAt = uploadedAt;
    }

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

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}