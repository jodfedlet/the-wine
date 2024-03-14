package me.jodfedlet.thewine.modules.product;


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
import me.jodfedlet.thewine.modules.product.dto.in.CreateProductInDto;
import me.jodfedlet.thewine.modules.product.dto.out.ProductOutDto;
import me.jodfedlet.thewine.modules.product.service.ProductService;

@Tag(name = "products", description = "The product implementation")
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @Operation(summary = "Create a new product")
    @ApiResponse(responseCode = "201", description = "product created")
    public ResponseEntity<ProductOutDto> create(@RequestBody CreateProductInDto dto) {
        return ResponseEntity.ok(productService.create(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a product by id")
    @ApiResponse(responseCode = "200", description = "product found")
    public ResponseEntity<ProductOutDto> findOne(@PathVariable String id) {
        return ResponseEntity.ok(productService.findOne(id));
    }

    @GetMapping
    @Operation(summary = "Find all products")
    @ApiResponse(responseCode = "200", description = "products found")
    public ResponseEntity<List<ProductOutDto>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a product")
    @ApiResponse(responseCode = "200", description = "product updated")
    public ResponseEntity<ProductOutDto> update(@PathVariable String id, @RequestBody CreateProductInDto dto) {
        return ResponseEntity.ok(productService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product")
    @ApiResponse(responseCode = "204", description = "product deleted")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
