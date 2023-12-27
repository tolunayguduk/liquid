package com.liquid.product.mapper;

import com.liquid.product.dto.CatagoryDto;
import com.liquid.product.entity.CatagoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	public CatagoryDto toDto(CatagoryEntity entity);

	public List<CatagoryDto> toDto(List<CatagoryEntity> entity);

	public CatagoryEntity toEntity(CatagoryDto dto);

	public List<CatagoryEntity> toEntity(List<CatagoryDto> dto);

}
