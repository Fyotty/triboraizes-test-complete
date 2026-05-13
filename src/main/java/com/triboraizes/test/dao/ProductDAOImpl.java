package com.triboraizes.test.dao;

import com.triboraizes.test.model.Product;
import com.triboraizes.test.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository repository;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductDAOImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        return repository.save(product);
    }
}
