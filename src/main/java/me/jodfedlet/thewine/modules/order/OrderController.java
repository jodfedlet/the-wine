package me.jodfedlet.thewine.modules.order;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.jodfedlet.thewine.modules.order.dto.in.SaleProductToCustomerInDto;
import me.jodfedlet.thewine.modules.order.service.OrderService;

@Tag(name = "orders", description = "The order implementation")
@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @Operation(summary = "Sale products to customer")
    @ApiResponse(responseCode = "201", description = "product created")
    public ResponseEntity<String> create(@RequestBody Set<SaleProductToCustomerInDto> dto) {
        return ResponseEntity.ok(orderService.saleProductToCustomer(dto));
    }
}
