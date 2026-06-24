package com.carmina.skin_profile_system.repository;

import com.carmina.skin_profile_system.entity.SkinImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkinImageRepository extends JpaRepository<SkinImage, Long> {
    List<SkinImage> findByConsultationId(Long consultationId);
}