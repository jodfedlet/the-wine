package me.jodfedlet.thewine.shared.auth.dto;

import lombok.Builder;

@Builder
public record AuthenticateReqDto(
    String email,
    String password
) {
    
}
