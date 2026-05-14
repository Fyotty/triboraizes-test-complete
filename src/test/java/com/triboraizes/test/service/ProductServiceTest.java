package com.triboraizes.test.service;

import com.triboraizes.test.domain.dto.ProductDTO;
import com.triboraizes.test.domain.entity.Product;
import com.triboraizes.test.domain.form.ProductForm;
import com.triboraizes.test.domain.mapper.ProductMapper;
import com.triboraizes.test.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @Mock
    private ProductMapper mapper;

    @InjectMocks
    private ProductService productService;

    @Test
    void createProduct_ShouldReturnProductDTO() {
        ProductForm form = new ProductForm(
                "Test Product",
                "Test Description",
                BigDecimal.TEN,
                10
        );

        Product product = Product.builder()
                .uuid(UUID.randomUUID())
                .name(form.name())
                .description(form.description())
                .price(form.price())
                .quantity(form.quantity())
                .build();

        ProductDTO dto = ProductDTO.builder()
                .id(product.getId())
                .uuid(product.getUuid())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();

        when(mapper.toModel(form)).thenReturn(product);
        when(repository.save(product)).thenReturn(product);
        when(mapper.toDto(product)).thenReturn(dto);

        ProductDTO result = productService.createProduct(form);

        assertNotNull(result);
        assertEquals(form.name(), result.getName());
        verify(repository, times(1)).save(product);
    }

    @Test
    void getProductById_ShouldReturnProductDTO() {
        UUID id = UUID.randomUUID();
        Product product = Product.builder()
                .uuid(id)
                .name("Test Product")
                .description("Test Description")
                .price(BigDecimal.TEN)
                .quantity(10)
                .build();

        ProductDTO dto = ProductDTO.builder()
                .id(product.getId())
                .uuid(product.getUuid())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();

        when(repository.findById(id)).thenReturn(Optional.of(product));
        when(mapper.toDto(product)).thenReturn(dto);

        ProductDTO result = productService.getProductById(id);

        assertNotNull(result);
        assertEquals(id, result.getUuid());
    }

    @Test
    void getProductById_WhenNotFound_ShouldThrowException() {
        UUID id = UUID.randomUUID();
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> productService.getProductById(id));
    }
}
