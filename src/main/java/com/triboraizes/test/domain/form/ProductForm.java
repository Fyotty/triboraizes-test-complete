package com.triboraizes.test.domain.form;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ProductForm(
        @NotNull(message = "O nome do produto ser informado!")
        @NotBlank(message = "O nome do produto não pode estar vazio!")
        String name,
        @NotNull(message = "A descrição do produto ser informado!")
        @NotBlank(message = "A descrição do produto não pode estar vazio!")
        String description,
        @NotNull(message = "O preço do produto deve ser informado!")
        @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero!")
        BigDecimal price,
        @NotNull(message = "A quantidade deve ser informada!")
        @Min(value = 1, message = "A quantidade deve ser pelo menos 1!")
        Integer quantity
) {
}
