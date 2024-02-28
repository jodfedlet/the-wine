package me.jodfedlet.thewine.modules.product.service;

import lombok.RequiredArgsConstructor;
import me.jodfedlet.thewine.modules.product.ProductMapper;
import me.jodfedlet.thewine.modules.product.dto.in.CreateProductInDto;
import me.jodfedlet.thewine.modules.product.dto.out.ProductOutDto;
import me.jodfedlet.thewine.modules.product.entity.Product;
import me.jodfedlet.thewine.modules.product.repository.ProductRepository;
import me.jodfedlet.thewine.shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductOutDto create(CreateProductInDto createProductInDto) {

        Product product = Product.builder()
                .name(createProductInDto.name())
                .description(createProductInDto.description())
                .price(createProductInDto.price())
                .discount(createProductInDto.discount())
                .category(createProductInDto.category())
                .availableInStock(createProductInDto.availableInStock())
                .isActive(true)
                //.metadata(createProductInDto.metadata())
                .build();

        Product createdProduct = productRepository.save(product);
        return ProductMapper.toDto(createdProduct);
    }

    @Override
    public ProductOutDto update(String id, CreateProductInDto updateProductInDto) {
        this.findOne(id);

        Product product = ProductMapper.toEntity(updateProductInDto);

        Product updatedProduct = productRepository.save(product);
        return ProductMapper.toDto(updatedProduct);
    }

    @Override
    public ProductOutDto findOne(String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
        return ProductMapper.toDto(product);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductOutDto> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }
}
