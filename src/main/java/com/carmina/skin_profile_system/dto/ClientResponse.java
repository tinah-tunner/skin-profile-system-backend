package com.carmina.skin_profile_system.dto;

import com.carmina.skin_profile_system.entity.Client;

public class ClientResponse {

    private Client client;

    public ClientResponse() {}

    public ClientResponse(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}