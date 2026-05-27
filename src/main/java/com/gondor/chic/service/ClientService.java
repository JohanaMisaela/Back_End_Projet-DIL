package com.gondor.chic.service;

import com.gondor.chic.entity.Client;
import com.gondor.chic.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> authentifier(String pseudo, String motDePasse) {
        return clientRepository.findByPseudoAndMotDePasse(pseudo, motDePasse);
    }
}
