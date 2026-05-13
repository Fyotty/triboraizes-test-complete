package com.triboraizes.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends GenericModel {

    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;

}
