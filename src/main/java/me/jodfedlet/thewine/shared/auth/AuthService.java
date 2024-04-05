package me.jodfedlet.thewine.shared.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import me.jodfedlet.thewine.modules.employee.entity.Employee;
import me.jodfedlet.thewine.modules.employee.repository.EmployeeRepository;
import me.jodfedlet.thewine.shared.TokenServiceInterface;
import me.jodfedlet.thewine.shared.auth.dto.AuthenticateReqDto;
import me.jodfedlet.thewine.shared.auth.dto.AuthenticateResDto;

@Service
public class AuthService implements UserDetailsService {
    
    @Autowired
    private TokenServiceInterface tokenService;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EmployeeRepository userRepository;
    

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
    }
}
