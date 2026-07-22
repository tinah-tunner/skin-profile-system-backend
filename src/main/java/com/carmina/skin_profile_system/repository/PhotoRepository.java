package com.carmina.skin_profile_system.repository;

import com.carmina.skin_profile_system.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    List<Photo> findByClientIdOrderByUploadedAtDesc(Long clientId);

}