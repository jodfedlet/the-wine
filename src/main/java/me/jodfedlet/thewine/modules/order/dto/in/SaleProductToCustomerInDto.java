package me.jodfedlet.thewine.modules.order.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record SaleProductToCustomerInDto(
        @JsonProperty("product_id")
        String productId,
        Integer quantity
) {
}
