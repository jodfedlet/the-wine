package me.jodfedlet.thewine.shared.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import me.jodfedlet.thewine.modules.employee.entity.Employee;
import me.jodfedlet.thewine.modules.employee.model.EmployeeRole;
import me.jodfedlet.thewine.modules.employee.repository.EmployeeRepository;

@RequiredArgsConstructor
@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Employee employee = Employee.builder()
                .name("Admin updated")
                .email("admin@thewine.com")
                .password(passwordEncoder.encode("admin"))
                .documentId("12232")
                .role(EmployeeRole.ADMIN)
                .build();

        employeeRepository.save(employee);

    }

}
