package me.jodfedlet.thewine.modules.product.service;

import me.jodfedlet.thewine.modules.product.dto.in.CreateProductInDto;
import me.jodfedlet.thewine.modules.product.dto.out.ProductOutDto;

import java.util.List;

public interface ProductService {

    ProductOutDto create(CreateProductInDto createProductInDto);

    ProductOutDto update(String id, CreateProductInDto updateProductInDto);

    ProductOutDto findOne(String id);

    void delete(String id);

    List<ProductOutDto> findAll();
}
