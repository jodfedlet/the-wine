package me.jodfedlet.thewine.modules.product.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import me.jodfedlet.thewine.modules.product.model.enums.ProductCategory;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;

@Builder
public record ProductOutDto(
        String id,
        String name,
        String description,
        BigDecimal price,
        BigDecimal discount,
        ProductCategory category,

        @JsonProperty("available_in_stock")
        Integer availableInStock,

        @JsonProperty("is_active")
        boolean isActive,

      //  Map<String, Object> metadata,

        @JsonProperty("created_at")
        Instant createdAt,

        @JsonProperty("updated_at")
        Instant updatedAt
) {
}
