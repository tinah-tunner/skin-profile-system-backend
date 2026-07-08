package com.carmina.skin_profile_system.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploadService {

    private final Cloudinary cloudinary;

    public ImageUploadService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadImage(MultipartFile file) throws IOException {

        Map<?, ?> uploadResult = cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap(
                        "folder", "skin-profile-system"
                )
        );

        return uploadResult.get("secure_url").toString();
    }

    public String deleteImage(String publicId) throws IOException {

        Map<?, ?> result = cloudinary.uploader().destroy(
                publicId,
                ObjectUtils.emptyMap()
        );

        return result.get("result").toString();
    }
}