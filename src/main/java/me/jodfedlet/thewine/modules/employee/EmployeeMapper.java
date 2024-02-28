package me.jodfedlet.thewine.modules.employee;

import me.jodfedlet.thewine.modules.employee.dto.in.CreateEmployeeInDto;
import me.jodfedlet.thewine.modules.employee.dto.out.EmployeeOutDto;
import me.jodfedlet.thewine.modules.employee.entity.Employee;

public class EmployeeMapper {
    public static Employee toEntity(CreateEmployeeInDto dto) {
        return Employee.builder()
                .name(dto.name())
                .documentId(dto.documentId())
                .email(dto.email())
                .role(dto.role())
                .salary(dto.salary())
                .build();

    }

    public static EmployeeOutDto toDto(Employee entity) {
        return EmployeeOutDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .documentId(entity.getDocumentId())
                .email(entity.getEmail())
                .role(entity.getRole())
                .salary(entity.getSalary())
                .active(entity.isActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
