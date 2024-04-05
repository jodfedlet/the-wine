package me.jodfedlet.thewine.modules.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.jodfedlet.thewine.modules.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Optional<Employee> findByName(String name);

    Optional<Employee> findByEmail(String email);
}
