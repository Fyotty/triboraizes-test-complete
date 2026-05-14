package com.triboraizes.test.service;

import com.triboraizes.test.dto.ProductDTO;
import com.triboraizes.test.model.Product;
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

    @InjectMocks
    private ProductService productService;

    @Test
    void createProduct_ShouldReturnProductDTO() {
        ProductDTO dto = ProductDTO.builder()
                .name("Test Product")
                .price(BigDecimal.TEN)
                .quantity(10)
                .build();

        Product product = Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();

        when(repository.save(any(Product.class))).thenReturn(product);

        ProductDTO result = productService.createProduct(dto);

        assertNotNull(result);
        assertEquals(dto.getName(), result.getName());
        verify(repository, times(1)).save(any(Product.class));
    }

    @Test
    void getProductById_ShouldReturnProductDTO() {
        UUID id = UUID.randomUUID();
        Product product = Product.builder()
                .name("Test Product")
                .price(BigDecimal.TEN)
                .quantity(10)
                .build();

        when(repository.findById(id)).thenReturn(Optional.of(product));

        ProductDTO result = productService.getProductById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void getProductById_WhenNotFound_ShouldThrowException() {
        UUID id = UUID.randomUUID();
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> productService.getProductById(id));
    }
}
