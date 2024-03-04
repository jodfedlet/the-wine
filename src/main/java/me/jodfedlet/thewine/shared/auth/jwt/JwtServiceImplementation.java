package me.jodfedlet.thewine.shared.auth.jwt;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import me.jodfedlet.thewine.modules.employee.entity.Employee;
import me.jodfedlet.thewine.shared.TokenServiceInterface;
import me.jodfedlet.thewine.shared.exceptions.UnauthenticatedResourceException;

@Service
public class JwtServiceImplementation implements TokenServiceInterface {

    @Value("${api.security.jwt.secret}")
    private static String secretKey;

    @Value("${api.issuer.name}")
    private static String issuer;

    @Override
    public String generateToken(String userEmail) {
         try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(userEmail)
                    .withExpiresAt(Date.from(getExpirationTime()))
                    .sign(algorithm);
        } catch (Exception e) {
            throw new UnauthenticatedResourceException("Failed to sign in, please retry.");
        }
    }

      private Instant getExpirationTime() {
        return LocalDateTime.now().plusHours(24).atZone(ZoneId.systemDefault()).toInstant();
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getSubject();
            return true;
        } catch (Exception e) {
            throw new UnauthenticatedResourceException("Invalid user token or it s expired, please retry.");
        }
    }

    @Override
    public Employee retrieveAuthUser(String token) {
         if (SecurityContextHolder.getContext().getAuthentication() == null) {
            throw new UnauthenticatedResourceException("Invalid user token or it s expired, please retry.");
        }

        return (Employee) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }
    
}
