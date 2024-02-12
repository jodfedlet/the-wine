package me.jodfedlet.thewine.modules.employee;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.jodfedlet.thewine.modules.customer.dto.in.CreateEmployeeInDto;
import me.jodfedlet.thewine.modules.employee.dto.out.EmployeeOutDto;
import me.jodfedlet.thewine.modules.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "employees", description = "The employee implementation")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    @Operation(summary = "Create a new employee")
    @ApiResponse(responseCode = "201", description = "employee created")
    public ResponseEntity<EmployeeOutDto> create(@RequestBody CreateEmployeeInDto dto) {
        return ResponseEntity.ok(employeeService.create(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a employee by id")
    @ApiResponse(responseCode = "200", description = "employee found")
    public ResponseEntity<EmployeeOutDto> findOne(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping
    @Operation(summary = "Find all employees")
    @ApiResponse(responseCode = "200", description = "employees found")
    public ResponseEntity<List<EmployeeOutDto>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a employee")
    @ApiResponse(responseCode = "200", description = "employee updated")
    public ResponseEntity<EmployeeOutDto> update(@PathVariable String id, @RequestBody CreateEmployeeInDto dto) {
        return ResponseEntity.ok(employeeService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a employee")
    @ApiResponse(responseCode = "204", description = "employee deleted")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
