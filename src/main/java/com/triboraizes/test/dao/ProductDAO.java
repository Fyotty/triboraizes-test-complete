package com.triboraizes.test.dao;

import com.triboraizes.test.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDAO {
    Product save(Product product);
    Optional<Product> findById(UUID id);
    List<Product> findAll();
    void deleteById(UUID id);
    Product update(Product product);
}
