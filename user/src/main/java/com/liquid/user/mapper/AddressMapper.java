package com.liquid.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.liquid.user.dto.UserAddressDto;
import com.liquid.user.entity.UserAddressEntity;

@Mapper(componentModel = "spring")
public interface AddressMapper {

	AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

	public UserAddressDto toDto(UserAddressEntity entity);

	public List<UserAddressDto> toDto(List<UserAddressEntity> entity);

	public UserAddressEntity toEntity(UserAddressDto dto);

	public List<UserAddressEntity> toEntity(List<UserAddressDto> dto);
}
