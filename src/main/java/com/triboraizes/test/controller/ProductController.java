package com.triboraizes.test.controller;

import com.triboraizes.test.domain.dto.ProductDTO;
import com.triboraizes.test.domain.form.ProductForm;
import com.triboraizes.test.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "Endpoints para gerenciamento de produtos")
@SecurityRequirement(name = "bearerAuth")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @Operation(summary = "Cria um novo produto")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductForm form) {
        return ResponseEntity.ok(productService.createProduct(form));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um produto existente")
    public ResponseEntity<ProductDTO> update(@PathVariable UUID id, @RequestBody ProductForm form) {
        return ResponseEntity.ok(productService.updateProduct(id, form));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um produto existente")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Lista todos os produtos")
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta um produto específico por ID")
    public ResponseEntity<ProductDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
}
