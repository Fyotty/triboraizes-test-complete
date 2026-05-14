package com.triboraizes.test.service;

import com.triboraizes.test.domain.dto.ProductDTO;
import com.triboraizes.test.domain.entity.Product;
import com.triboraizes.test.domain.form.ProductForm;
import com.triboraizes.test.domain.mapper.ProductMapper;
import com.triboraizes.test.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductDTO createProduct(ProductForm form) {
        Product product = mapper.toModel(form);
        Product saved = repository.save(product);
        return mapToDTO(saved);
    }

    public ProductDTO updateProduct(UUID id, ProductForm form) {
        Product product = findByUuid(id);

        product.setName(form.name());
        product.setDescription(form.description());
        product.setPrice(form.price());
        product.setQuantity(form.quantity());
        Product updated = repository.save(product);
        return mapToDTO(updated);
    }

    public void deleteProduct(UUID id) {
        repository.deleteById(id);
    }

    public List<ProductDTO> getAllProducts() {
        return mapper.toDto(repository.findAll());
    }

    private Product findByUuid(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não enontrado"));
    }

    public ProductDTO getProductById(UUID id) {
        Product product = findByUuid(id);
        return mapToDTO(product);
    }

    private ProductDTO mapToDTO(Product product) {
        return mapper.toDto(product);
    }
}
