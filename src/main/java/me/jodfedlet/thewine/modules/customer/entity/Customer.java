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
    private String documentId;
    private boolean sellOnCredit;
}
