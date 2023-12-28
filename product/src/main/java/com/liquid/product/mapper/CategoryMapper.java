package com.liquid.product.mapper;

import com.liquid.product.dto.CategoryDto;
import com.liquid.product.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	public CategoryDto toDto(CategoryEntity entity);
	public List<CategoryDto> toDto(List<CategoryEntity> entity);
	public CategoryEntity toEntity(CategoryDto dto);
	public List<CategoryEntity> toEntity(List<CategoryDto> dto);
}
