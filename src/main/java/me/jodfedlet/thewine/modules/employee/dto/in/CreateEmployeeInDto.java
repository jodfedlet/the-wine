package me.jodfedlet.thewine.modules.employee.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import me.jodfedlet.thewine.modules.employee.model.EmployeeRole;

import java.math.BigDecimal;

@Builder
public record CreateEmployeeInDto(
        String name,

        @JsonProperty("document_id")
        String documentId,

        String email,

        String password,

        EmployeeRole role,

        BigDecimal salary
) {
}
