package me.jodfedlet.thewine.shared.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.jodfedlet.thewine.shared.auth.dto.AuthenticateReqDto;
import me.jodfedlet.thewine.shared.auth.dto.AuthenticateResDto;

@RestController
@Tag(name = "auth", description = "The auth implementation")
@RequestMapping("v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticateResDto> login(@RequestBody AuthenticateReqDto authDto) {
        AuthenticateResDto response = authService.authenticate(authDto);
        return ResponseEntity.ok(response);
    }
    
}
