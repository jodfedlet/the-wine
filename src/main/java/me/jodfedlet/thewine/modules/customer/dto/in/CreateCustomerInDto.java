package me.jodfedlet.thewine.modules.customer.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CreateCustomerInDto(
    String name,

    @JsonProperty("document_id")
    String documentId,

    @JsonProperty("sell_on_credit")
    boolean sellOnCredit
) {
}
