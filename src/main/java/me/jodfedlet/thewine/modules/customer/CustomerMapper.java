package me.jodfedlet.thewine.modules.customer;

import me.jodfedlet.thewine.modules.customer.dto.in.CreateCustomerInDto;
import me.jodfedlet.thewine.modules.customer.dto.out.CustomerOutDto;
import me.jodfedlet.thewine.modules.customer.entity.Customer;

public class CustomerMapper {
    public static Customer toEntity(CreateCustomerInDto dto) {
        return Customer.builder()
            .name(dto.name())
            .documentId(dto.documentId())
            .sellOnCredit(dto.sellOnCredit())
            .build();
    }

    public static CustomerOutDto toDto(Customer entity) {
        return CustomerOutDto.builder()
            .id(entity.getId())
            .name(entity.getName())
            .documentId(entity.getDocumentId())
            .sellOnCredit(entity.isSellOnCredit())
            .build();
    }
}
