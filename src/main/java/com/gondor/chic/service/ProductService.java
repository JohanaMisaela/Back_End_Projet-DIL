package com.gondor.chic.service;

import com.gondor.chic.entity.Product;
import com.gondor.chic.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> obtenirProduitDuJour() {
        return productRepository.findByIsProduitDuJourTrue();
    }
}
