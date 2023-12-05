package com.liquid.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.liquid.user.dto.AddressDto;
import com.liquid.user.entity.AddressEntity;

@Mapper(componentModel = "spring")
public interface AddressMapper {
	
	AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

	public AddressDto toDto(AddressEntity entity);

	public List<AddressDto> toDto(List<AddressEntity> entity);


	public AddressEntity toEntity(AddressDto dto);

	public List<AddressEntity> toEntity(List<AddressDto> dto);

}
