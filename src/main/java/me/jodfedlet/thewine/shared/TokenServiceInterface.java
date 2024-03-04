package me.jodfedlet.thewine.shared;

import me.jodfedlet.thewine.modules.employee.entity.Employee;

public interface TokenServiceInterface {
    String generateToken(String username);
    boolean validateToken(String token);
    Employee retrieveAuthUser(String token);
}
