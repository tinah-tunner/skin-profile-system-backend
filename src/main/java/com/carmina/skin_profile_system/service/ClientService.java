package com.carmina.skin_profile_system.service;

import com.carmina.skin_profile_system.dto.ClientRequest;
import com.carmina.skin_profile_system.entity.Client;
import com.carmina.skin_profile_system.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.carmina.skin_profile_system.entity.Photo;
import com.carmina.skin_profile_system.repository.PhotoRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final NotificationService notificationService;
    private final ImageUploadService imageUploadService;
    private final PhotoRepository photoRepository;

    public ClientService(
        ClientRepository clientRepository,
        NotificationService notificationService,
        ImageUploadService imageUploadService,
        PhotoRepository photoRepository
) {
    this.clientRepository = clientRepository;
    this.notificationService = notificationService;
    this.imageUploadService = imageUploadService;
    this.photoRepository = photoRepository;
}

    // ===============================
    // CREATE CLIENT
    // ===============================
    public Client createClient(ClientRequest request) {

        if (clientRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("A client with this email already exists.");
        }

        Client client = new Client();

        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        client.setEmail(request.getEmail());
        client.setPhoneNumber(request.getPhoneNumber());
        client.setDateOfBirth(request.getDateOfBirth());
        client.setGender(request.getGender());
        client.setAddress(request.getAddress());
        client.setEmergencyContact(request.getEmergencyContact());

        client.setSkinType(request.getSkinType());
        client.setSkinConcerns(request.getSkinConcerns());

        client.setAllergies(request.getAllergies());
        client.setCurrentMedication(request.getCurrentMedication());
        client.setMedicalConditions(request.getMedicalConditions());

        client.setTherapistNotes(request.getTherapistNotes());

        Client savedClient = clientRepository.save(client);

        savedClient.setClientNumber(
                String.format("BK-%06d", savedClient.getId())
        );

        Client finalClient = clientRepository.save(savedClient);

        notificationService.create(
                "Client",
                "New client registered: "
                        + finalClient.getFirstName()
                        + " "
                        + finalClient.getLastName()
        );

        return finalClient;
    }

    // ===============================
    // GET ALL CLIENTS
    // ===============================
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // ===============================
    // GET CLIENT BY ID
    // ===============================
    public Client getClient(Long id) {

        return clientRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Client not found."));
    }

    // ===============================
    // UPLOAD IMAGES TO CLOUDINARY
    // ===============================
public Client uploadImages(
        Long id,
        MultipartFile beforeImage,
        MultipartFile afterImage
) throws IOException {

    Client client = getClient(id);

    if (beforeImage != null && !beforeImage.isEmpty()) {

        String url = imageUploadService.uploadImage(beforeImage);

        Photo photo = new Photo();
        photo.setClient(client);
        photo.setImageUrl(url);
        photo.setPhotoType("BEFORE");

        photoRepository.save(photo);
    }

    if (afterImage != null && !afterImage.isEmpty()) {

        String url = imageUploadService.uploadImage(afterImage);

        Photo photo = new Photo();
        photo.setClient(client);
        photo.setImageUrl(url);
        photo.setPhotoType("AFTER");

        photoRepository.save(photo);
    }

    return client;
}

    // ===============================
    // DELETE CLIENT
    // ===============================
    public void deleteClient(Long id) {

        Client client = getClient(id);

        notificationService.create(
                "Client",
                "Client deleted: "
                        + client.getFirstName()
                        + " "
                        + client.getLastName()
        );

        clientRepository.delete(client);
    }

   public Client updateClient(Long id, ClientRequest request){
    Client client = getClient(id);

    client.setFirstName(request.getFirstName());
    client.setLastName(request.getLastName());
    client.setEmail(request.getEmail());
    client.setPhoneNumber(request.getPhoneNumber());
    client.setDateOfBirth(request.getDateOfBirth());
    client.setGender(request.getGender());
    client.setAddress(request.getAddress());
    client.setEmergencyContact(request.getEmergencyContact());

    client.setSkinType(request.getSkinType());
    client.setSkinConcerns(request.getSkinConcerns());

    client.setAllergies(request.getAllergies());
    client.setCurrentMedication(request.getCurrentMedication());
    client.setMedicalConditions(request.getMedicalConditions());
    client.setTherapistNotes(request.getTherapistNotes());

    client.setUpdatedAt(LocalDateTime.now());
    client.setUpdatedBy("Therapist");

    notificationService.create(
        "Client",
        "Client updated successfully."
    );

    return clientRepository.save(client);
} 
}
