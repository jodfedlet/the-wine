package me.jodfedlet.thewine.modules.employee.service;

import me.jodfedlet.thewine.modules.employee.dto.in.CreateEmployeeInDto;
import me.jodfedlet.thewine.modules.employee.dto.out.EmployeeOutDto;

import java.util.List;

public interface EmployeeService {
    EmployeeOutDto create(CreateEmployeeInDto customer);
    EmployeeOutDto update(String id, CreateEmployeeInDto customer);
    void delete(String id);
    EmployeeOutDto findById(String id);
    List<EmployeeOutDto> findAll();
    EmployeeOutDto findByName(String name);
}
