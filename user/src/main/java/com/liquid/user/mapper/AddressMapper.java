package com.liquid.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.liquid.user.dto.AddressDto;
import com.liquid.user.entity.UserAddressEntity;

@Mapper(componentModel = "spring")
public interface AddressMapper {

	AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

	public AddressDto toDto(UserAddressEntity entity);

	public List<AddressDto> toDto(List<UserAddressEntity> entity);

	public UserAddressEntity toEntity(AddressDto dto);

	public List<UserAddressEntity> toEntity(List<AddressDto> dto);
}
