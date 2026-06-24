
package com.carmina.skin_profile_system.service;

import com.carmina.skin_profile_system.entity.Client;
import com.carmina.skin_profile_system.repository.ClientRepository;
import org.springframework.stereotype.Service;
import com.carmina.skin_profile_system.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Client not found with id: " + id
                        ));
    }

    public Client updateClient(Long id, Client updated) {

        Client client = getClientById(id);

        client.setFirstName(updated.getFirstName());
        client.setLastName(updated.getLastName());
        client.setAge(updated.getAge());
        client.setPhone(updated.getPhone());
        client.setEmail(updated.getEmail());

        // Only keep these if they exist in Client.java
        client.setSkinType(updated.getSkinType());
        client.setAllergies(updated.getAllergies());
        client.setMedicalNotes(updated.getMedicalNotes());

        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public List<Client> searchClients(String name) {
        return clientRepository.findByFirstNameContainingIgnoreCase(name);
    }
}