package me.jodfedlet.thewine.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ErrorResponseDto(
        @JsonProperty("status_code")
        Integer statusCode,
        @JsonProperty("error_code")
        HttpStatus errorCode,

        String message
) {
}
