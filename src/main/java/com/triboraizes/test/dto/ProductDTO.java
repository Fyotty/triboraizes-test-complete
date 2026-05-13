package com.triboraizes.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private UUID uuid;
    private Boolean active;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
