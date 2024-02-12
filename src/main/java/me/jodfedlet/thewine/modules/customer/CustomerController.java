package me.jodfedlet.thewine.modules.customer;


import me.jodfedlet.thewine.modules.customer.dto.in.CreateCustomerInDto;
import me.jodfedlet.thewine.modules.customer.dto.out.CustomerOutDto;
import me.jodfedlet.thewine.modules.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerOutDto> createCustomer(@RequestBody CreateCustomerInDto createCustomerInDto) {
        return ResponseEntity.ok(customerService.create(createCustomerInDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOutDto> findOne(@PathVariable String id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerOutDto>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerOutDto> update(@PathVariable String id, @RequestBody CreateCustomerInDto createCustomerInDto) {
        return ResponseEntity.ok(customerService.update(id, createCustomerInDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
