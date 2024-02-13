package me.jodfedlet.thewine.modules.product.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CreateEmployeeInDto(
        String name,

        @JsonProperty("document_id")
        String documentId,

        String email,

        String password,

        String role,

        BigDecimal salary
) {
}
