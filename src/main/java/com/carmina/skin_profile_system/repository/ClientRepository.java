package com.carmina.skin_profile_system.repository;

import com.carmina.skin_profile_system.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByFirstNameContainingIgnoreCase(String name);

}