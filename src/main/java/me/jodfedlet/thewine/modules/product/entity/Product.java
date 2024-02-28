package me.jodfedlet.thewine.modules.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import me.jodfedlet.thewine.modules.product.model.enums.ProductCategory;
import me.jodfedlet.thewine.shared.AbstractEntity;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends AbstractEntity {
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal discount;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @Column(name = "available_in_stock")
    private Integer availableInStock;

    @Column(name = "is_active")
    private boolean isActive;

    //@JdbcTypeCode(SqlTypes.JSON)
    //private Map<String, Object> metadata;

}
