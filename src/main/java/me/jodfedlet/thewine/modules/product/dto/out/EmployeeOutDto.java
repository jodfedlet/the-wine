package me.jodfedlet.thewine.modules.product.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
public record EmployeeOutDto(
        String id,
        String name,

        @JsonProperty("document_id")
        String documentId,

        String email,

        String role,

        BigDecimal salary,

        boolean active,

        @JsonProperty("created_at")
        Instant createdAt,

        @JsonProperty("updated_at")
        Instant updatedAt
) {
}
