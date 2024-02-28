package me.jodfedlet.thewine.modules.employee.service;

import me.jodfedlet.thewine.modules.employee.dto.in.CreateEmployeeInDto;
import me.jodfedlet.thewine.modules.employee.dto.out.EmployeeOutDto;

import java.util.List;

public interface EmployeeService {
    EmployeeOutDto create(CreateEmployeeInDto employeeInDto);
    EmployeeOutDto update(String id, CreateEmployeeInDto employeeInDto);
    EmployeeOutDto findById(String id);
    List<EmployeeOutDto> findAll();

    void delete(String id);
    EmployeeOutDto findByName(String name);
}
