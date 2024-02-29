package me.jodfedlet.thewine.modules.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import me.jodfedlet.thewine.modules.customer.entity.Customer;
import me.jodfedlet.thewine.modules.order.model.enums.ProductCategory;
import me.jodfedlet.thewine.shared.AbstractEntity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    private BigDecimal discount;

    private BigDecimal totalPrice;

    @OneToMany
    private Set<OrderItem> orderItems = new HashSet<>();

    private String customerId;

    public BigDecimal getTotal() {
        if (discount == null || discount.equals(BigDecimal.ZERO)) {
            return orderItems.stream()
                    .map(OrderItem::getSubTotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        } else {
            return orderItems.stream()
                    .map(OrderItem::getSubTotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .subtract(discount);
        }
    }
}
