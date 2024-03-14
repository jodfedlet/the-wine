package me.jodfedlet.thewine.modules.customer;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.jodfedlet.thewine.modules.customer.dto.in.CreateCustomerInDto;
import me.jodfedlet.thewine.modules.customer.dto.out.CustomerOutDto;
import me.jodfedlet.thewine.modules.customer.service.CustomerService;

@Tag(name = "customers", description = "The customer implementation")
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @Operation(summary = "Create a new customer")
    @ApiResponse(responseCode = "201", description = "Customer created")
    public ResponseEntity<CustomerOutDto> createCustomer(@RequestBody CreateCustomerInDto createCustomerInDto) {
        return ResponseEntity.ok(customerService.create(createCustomerInDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a customer by id")
    @ApiResponse(responseCode = "200", description = "Customer found")
    public ResponseEntity<CustomerOutDto> findOne(@PathVariable String id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping
    @Operation(summary = "Find all customers")
    @ApiResponse(responseCode = "200", description = "Customers found")
    public ResponseEntity<List<CustomerOutDto>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a customer")
    @ApiResponse(responseCode = "200", description = "Customer updated")
    public ResponseEntity<CustomerOutDto> update(@PathVariable String id, @RequestBody CreateCustomerInDto createCustomerInDto) {
        return ResponseEntity.ok(customerService.update(id, createCustomerInDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a customer")
    @ApiResponse(responseCode = "204", description = "Customer deleted")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
