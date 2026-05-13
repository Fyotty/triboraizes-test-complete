package com.triboraizes.test.service;

import com.triboraizes.test.dao.ProductDAO;
import com.triboraizes.test.dto.ProductDTO;
import com.triboraizes.test.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDAO productDAO;

    public ProductDTO createProduct(ProductDTO dto) {
        Product product = Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();
        Product saved = productDAO.save(product);
        return mapToDTO(saved);
    }

    public ProductDTO updateProduct(UUID id, ProductDTO dto) {
        Product product = productDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        Product updated = productDAO.update(product);
        return mapToDTO(updated);
    }

    public void deleteProduct(UUID id) {
        productDAO.deleteById(id);
    }

    public List<ProductDTO> getAllProducts() {
        return productDAO.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(UUID id) {
        Product product = productDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return mapToDTO(product);
    }

    private ProductDTO mapToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
}
