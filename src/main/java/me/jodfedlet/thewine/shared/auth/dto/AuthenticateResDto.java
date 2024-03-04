package me.jodfedlet.thewine.shared.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public record AuthenticateResDto(
    @JsonProperty("access_token")
    String accessToken,
    @JsonProperty("user_name")
    String userName
) {
    
}
