package com.carmina.skin_profile_system.controller;

import com.carmina.skin_profile_system.dto.ClientRequest;
import com.carmina.skin_profile_system.entity.Client;
import com.carmina.skin_profile_system.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
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