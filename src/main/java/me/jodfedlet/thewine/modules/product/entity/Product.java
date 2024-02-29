package me.jodfedlet.thewine.modules.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import me.jodfedlet.thewine.modules.order.entity.OrderItem;
import me.jodfedlet.thewine.modules.product.model.enums.ProductCategory;
import me.jodfedlet.thewine.shared.AbstractEntity;
import me.jodfedlet.thewine.shared.exceptions.BadRequestException;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany
    private Set<OrderItem> orderItems = new HashSet<>();

    //@JdbcTypeCode(SqlTypes.JSON)
    //private Map<String, Object> metadata;

    public boolean checkIfAvailableInStock(Integer quantity) {
        if (this.availableInStock < quantity) {
            throw new BadRequestException("Not enough stock available");
        }
        return true;
    }
    public void decreaseStock(Integer quantity) {
        this.availableInStock -= quantity;
    }
}
