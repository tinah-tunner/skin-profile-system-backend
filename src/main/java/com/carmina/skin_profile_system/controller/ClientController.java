package com.carmina.skin_profile_system.controller;

import com.carmina.skin_profile_system.entity.Client;
import com.carmina.skin_profile_system.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id,
                               @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("Client deleted successfully");
    }

    @GetMapping("/search")
    public List<Client> search(@RequestParam String name) {
        return clientService.searchClients(name);
    }

    @GetMapping("/profiles")
    public List<Client> getProfiles() {
        return clientService.getAllClients();
    }
}