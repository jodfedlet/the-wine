package me.jodfedlet.thewine.modules.product.service;

import lombok.RequiredArgsConstructor;
import me.jodfedlet.thewine.modules.customer.dto.in.CreateEmployeeInDto;
import me.jodfedlet.thewine.modules.product.EmployeeMapper;
import me.jodfedlet.thewine.modules.product.dto.out.EmployeeOutDto;
import me.jodfedlet.thewine.modules.product.entity.Employee;
import me.jodfedlet.thewine.modules.product.repository.EmployeeRepository;
import me.jodfedlet.thewine.shared.exceptions.NotFoundException;
import me.jodfedlet.thewine.shared.exceptions.ResourceExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    /**
     * @param Employee
     * @return
     */
    @Override
    public EmployeeOutDto create(CreateEmployeeInDto employeeInDto) {

        if (employeeRepository.findByName(employeeInDto.name()).isPresent()) {
            throw new ResourceExistsException("Employee already exists");
        }

        Employee customer = EmployeeMapper.toEntity(employeeInDto);
        Employee savedEmployee = employeeRepository.save(customer);
        return EmployeeMapper.toDto(savedEmployee);
    }

    /**
     * @param Employee
     * @return
     */
    @Override
    public EmployeeOutDto update(String id, CreateEmployeeInDto employeeInDto) {

        this.findById(id);

        if (employeeRepository.findByName(employeeInDto.name()).isPresent()) {
            throw new ResourceExistsException("Employee already exists");
        }

        Employee customer = EmployeeMapper.toEntity(employeeInDto);
        Employee savedEmployee = employeeRepository.save(customer);
        return EmployeeMapper.toDto(savedEmployee);
    }

    /**
     * @param id
     */
    @Override
    public void delete(String id) {
        employeeRepository.deleteById(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public EmployeeOutDto findById(String id) {
        Employee customer = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found"));
        return EmployeeMapper.toDto(customer);
    }

    /**
     * @return
     */
    @Override
    public List<EmployeeOutDto> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::toDto)
                .toList();
    }

    /**
     * @param name
     * @return
     */
    @Override
    public EmployeeOutDto findByName(String name) {
        Optional<Employee> employee = employeeRepository.findByName(name);
        return employee.map(EmployeeMapper::toDto).orElse(null);
    }
}
