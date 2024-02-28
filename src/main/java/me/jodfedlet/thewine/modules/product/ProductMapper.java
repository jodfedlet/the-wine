package me.jodfedlet.thewine.modules.product;

import me.jodfedlet.thewine.modules.product.dto.in.CreateProductInDto;
import me.jodfedlet.thewine.modules.product.dto.out.ProductOutDto;
import me.jodfedlet.thewine.modules.product.entity.Product;

public class ProductMapper {
    public static Product toEntity(CreateProductInDto dto) {
        return Product.builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .category(dto.category())
                .availableInStock(dto.availableInStock())
                .isActive(dto.isActive())
               // .metadata(dto.metadata())
                .build();
    }

    public static ProductOutDto toDto(Product entity) {
        return ProductOutDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .category(entity.getCategory())
                .availableInStock(entity.getAvailableInStock())
                .isActive(entity.isActive())
               // .metadata(entity.getMetadata())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
