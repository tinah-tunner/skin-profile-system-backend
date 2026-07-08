package com.carmina.skin_profile_system.controller;

import com.carmina.skin_profile_system.service.ImageUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImageController {

    private final ImageUploadService imageUploadService;

    public ImageController(ImageUploadService imageUploadService) {
        this.imageUploadService = imageUploadService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(
            @RequestParam("file") MultipartFile file
    ) {

        try {

            String imageUrl = imageUploadService.uploadImage(file);

            Map<String, String> response = new HashMap<>();
            response.put("imageUrl", imageUrl);

            return ResponseEntity.ok(response);

        } catch (IOException e) {

            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }
}