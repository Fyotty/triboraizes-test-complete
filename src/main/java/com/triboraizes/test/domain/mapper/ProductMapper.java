package com.triboraizes.test.domain.mapper;

import com.triboraizes.test.domain.dto.ProductDTO;
import com.triboraizes.test.domain.entity.Product;
import com.triboraizes.test.domain.form.ProductForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductMapper implements EntityMapper<ProductDTO, Product, ProductForm>  {

    @Override
    public Product toModel(ProductForm form) {
        return  Product.builder()
                .uuid(UUID.randomUUID())
                .active(true)
                .name(form.name())
                .description(form.description())
                .price(form.price())
                .quantity(form.quantity())
                .build();
    }

    @Override
    public ProductDTO toDto(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .uuid(product.getUuid())
                .created_at(product.getCreated_at())
                .updated_at(product.getUpdated_at())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    @Override
    public ProductForm toForm(Product product) {
        return null;
    }

    @Override
    public List<Product> toModel(List<ProductDTO> productDTOS) {
        return List.of();
    }

    @Override
    public List<ProductDTO> toDto(List<Product> products) {
        return products.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductForm> toForm(List<Product> products) {
        return List.of();
    }
}
