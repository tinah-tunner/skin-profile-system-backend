package com.carmina.skin_profile_system.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/files")
@CrossOrigin
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            return "No file selected";
        }

        String uploadDir = "uploads/";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        File destination = new File(uploadDir + fileName);
        file.transferTo(destination);

        // return URL
        return "http://localhost:8080/uploads/" + fileName;
    }
}