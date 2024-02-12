package me.jodfedlet.thewine.modules.customer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import me.jodfedlet.thewine.shared.AbstractEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity {
    private String name;

    @Column(name = "document_id")
    private String documentId;

    @Column(name = "sell_on_credit")
    private boolean sellOnCredit;
}
