package me.jodfedlet.thewine.shared.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.jodfedlet.thewine.shared.auth.dto.AuthenticateReqDto;
import me.jodfedlet.thewine.shared.auth.dto.AuthenticateResDto;

@Tag(name = "auth", description = "The auth implementation")
@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticateResDto> login(@RequestBody AuthenticateReqDto authDto) {
        return ResponseEntity.ok(authService.authenticate(authDto));
    }
    
}
