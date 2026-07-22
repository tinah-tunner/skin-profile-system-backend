package com.carmina.skin_profile_system.controller;

import com.carmina.skin_profile_system.dto.ClientRequest;
import com.carmina.skin_profile_system.entity.Client;
import com.carmina.skin_profile_system.service.ClientService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


@PutMapping("/{id}")
public Client updateClient(
        @PathVariable Long id,
        @RequestBody ClientRequest request
) {
    return clientService.updateClient(id, request);
}


@PostMapping("/{id}/images")
public Client uploadImages(
        @PathVariable Long id,
        @RequestParam(value = "beforeImage", required = false) MultipartFile beforeImage,
        @RequestParam(value = "afterImage", required = false) MultipartFile afterImage
) throws IOException {

    return clientService.uploadImages(id, beforeImage, afterImage);
}
    // ===============================
    // CREATE CLIENT
    // ===============================
    @PostMapping
    public Client createClient(@RequestBody ClientRequest request) {
        return clientService.createClient(request);
    }

    // ===============================
    // GET ALL CLIENTS
    // ===============================
    @GetMapping
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    // ===============================
    // GET CLIENT BY ID
    // ===============================
    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    // ===============================
    // DELETE CLIENT
    // ===============================
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}