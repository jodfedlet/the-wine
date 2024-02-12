package me.jodfedlet.thewine.modules.customer.service;

import me.jodfedlet.thewine.modules.customer.dto.in.CreateCustomerInDto;
import me.jodfedlet.thewine.modules.customer.dto.out.CustomerOutDto;
import me.jodfedlet.thewine.modules.customer.entity.Customer;

import java.util.List;

public interface CustomerService {
    CustomerOutDto create(CreateCustomerInDto customer);
    CustomerOutDto update(String id, CreateCustomerInDto customer);
    void delete(String id);
    CustomerOutDto findById(String id);
    List<CustomerOutDto> findAll();
    CustomerOutDto findByName(String name);
}
