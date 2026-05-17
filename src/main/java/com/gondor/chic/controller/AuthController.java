package com.gondor.chic.controller;

import com.gondor.chic.entity.Client;
import com.gondor.chic.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final ClientRepository clientRepository;

    public AuthController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String pseudo = credentials.get("pseudo");
        String motDePasse = credentials.get("motDePasse");

        Optional<Client> client = clientRepository.findByPseudoAndMotDePasse(pseudo, motDePasse);

        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Identifiants invalides"));
        }
    }
}
