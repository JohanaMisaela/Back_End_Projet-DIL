package com.gondor.chic.config;

import com.gondor.chic.entity.Client;
import com.gondor.chic.entity.Product;
import com.gondor.chic.repository.ClientRepository;
import com.gondor.chic.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(ClientRepository clientRepository, ProductRepository productRepository) {
        return args -> {
            clientRepository.deleteAll();
            productRepository.deleteAll();

            Client frodon = Client.builder().prenom("Frodon").nom("Sacquet").pseudo("Leporteur").motDePasse("!totoXXS").build();
            Client sam = Client.builder().prenom("Sam").nom("Gamegie").pseudo("Lebrave").motDePasse("titiXXL").build();
            Client gandalf = Client.builder().prenom("Gandalf").nom("Le Gris").pseudo("Mithrandir").motDePasse("YouShallNotPass").build();
            clientRepository.saveAll(List.of(frodon, sam, gandalf));

            Product chaudron = Product.builder().libelle("Chaudron magique").prix(250.0).stock(678).isProduitDuJour(true).image("chaudron.png").build();
            Product cape = Product.builder().libelle("Cape magique").prix(180.0).stock(50).isProduitDuJour(false).image("cape.png").build();
            Product anneau = Product.builder().libelle("Anneau elfique").prix(999.0).stock(3).isProduitDuJour(false).image("anneau.png").build();
            productRepository.saveAll(List.of(chaudron, cape, anneau));

            System.out.println("Base de données initialisée avec succès !");
        };
    }
}
