package me.jodfedlet.thewine.modules.customer.service;

import lombok.RequiredArgsConstructor;
import me.jodfedlet.thewine.modules.customer.CustomerMapper;
import me.jodfedlet.thewine.modules.customer.dto.in.CreateCustomerInDto;
import me.jodfedlet.thewine.modules.customer.dto.out.CustomerOutDto;
import me.jodfedlet.thewine.modules.customer.entity.Customer;
import me.jodfedlet.thewine.modules.customer.repository.CustomerRepository;
import me.jodfedlet.thewine.shared.exceptions.NotFoundException;
import me.jodfedlet.thewine.shared.exceptions.ResourceExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * @param customer
     * @return
     */
    @Override
    public CustomerOutDto create(CreateCustomerInDto customerDto) {

        if (customerRepository.findByName(customerDto.name()).isPresent()) {
            throw new ResourceExistsException("Customer already exists");
        }

        Customer customer = CustomerMapper.toEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.toDto(savedCustomer);
    }

    /**
     * @param customer
     * @return
     */
    @Override
    public CustomerOutDto update(String id, CreateCustomerInDto customerDto) {

        this.findById(id);

        if (customerRepository.findByName(customerDto.name()).isPresent()) {
            throw new ResourceExistsException("Customer already exists");
        }

        Customer customer = CustomerMapper.toEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.toDto(savedCustomer);
    }

    /**
     * @param id
     */
    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public CustomerOutDto findById(String id) {
       Customer customer = customerRepository.findById(id)
               .orElseThrow(() -> new NotFoundException("Customer not found"));
       return CustomerMapper.toDto(customer);
    }

    /**
     * @return
     */
    @Override
    public List<CustomerOutDto> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper::toDto)
                .toList();
    }

    /**
     * @param name
     * @return
     */
    @Override
    public CustomerOutDto findByName(String name) {
        Optional<Customer> customer = customerRepository.findByName(name);
        return customer.map(CustomerMapper::toDto).orElse(null);
    }
}
