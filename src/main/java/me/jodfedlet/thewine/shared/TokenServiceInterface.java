package me.jodfedlet.thewine.shared;

import me.jodfedlet.thewine.modules.employee.entity.Employee;

public interface TokenServiceInterface {
    String generateToken(String username);
    String validateToken(String token);
    Employee retrieveAuthUser();
}
