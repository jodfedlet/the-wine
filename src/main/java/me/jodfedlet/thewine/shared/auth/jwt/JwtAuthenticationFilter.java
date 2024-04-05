package me.jodfedlet.thewine.shared.auth.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.jodfedlet.thewine.modules.employee.entity.Employee;
import me.jodfedlet.thewine.modules.employee.repository.EmployeeRepository;
import me.jodfedlet.thewine.shared.TokenServiceInterface;
import me.jodfedlet.thewine.shared.exceptions.NotFoundException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private EmployeeRepository userRepository;

    @Autowired
    private TokenServiceInterface jwtService;

    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = this.retrieveToken(request);

        if (token != null) {
            String subject = jwtService.validateToken(token);
            Employee user = userRepository.findByEmail(subject).orElseThrow(NotFoundException::new);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String retrieveToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
    
}
