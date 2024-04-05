package me.jodfedlet.thewine.shared.auth.dto;

import java.io.Serializable;

import lombok.Builder;

@Builder
public record AuthenticateReqDto(
    String email,
    String password
) implements Serializable {
    
}
