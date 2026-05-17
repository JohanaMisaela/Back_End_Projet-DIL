package com.gondor.chic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gondor.chic.entity.Client;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByPseudoAndMotDePasse(String pseudo, String motDePasse);
}
