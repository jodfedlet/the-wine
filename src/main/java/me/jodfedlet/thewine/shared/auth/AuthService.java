package me.jodfedlet.thewine.shared.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import me.jodfedlet.thewine.modules.employee.entity.Employee;
import me.jodfedlet.thewine.shared.TokenServiceInterface;
import me.jodfedlet.thewine.shared.auth.dto.AuthenticateReqDto;
import me.jodfedlet.thewine.shared.auth.dto.AuthenticateResDto;

@Service
public class AuthService {
    
    private final TokenServiceInterface tokenService;

    private final AuthenticationManager authenticationManager;
    

    @Autowired
    public AuthService(TokenServiceInterface tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticateResDto authenticate(AuthenticateReqDto authDto) {
        System.out.println("/".repeat(150));
        System.out.println(authDto.email());
        
        UsernamePasswordAuthenticationToken authenticationRequest = new UsernamePasswordAuthenticationToken(authDto.email(), authDto.password());
        authenticationManager.authenticate(authenticationRequest);

        String token = tokenService.generateToken(authDto.email());

        Employee authUser = tokenService.retrieveAuthUser(token);

        return AuthenticateResDto.builder()
            .accessToken(token)
            .userName(authUser.getName())
            .build();
        
    }
}
