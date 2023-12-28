package com.liquid.product.mapper;

import com.liquid.product.dto.ProductDto;
import com.liquid.product.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    public ProductDto toDto(ProductEntity entity);
    public List<ProductDto> toDto(List<ProductEntity> entity);
    public ProductEntity toEntity(ProductDto dto);
    public List<ProductEntity> toEntity(List<ProductDto> dto);
}
