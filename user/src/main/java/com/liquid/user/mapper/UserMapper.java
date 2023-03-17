package com.liquid.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.liquid.user.dto.UserDto;
import com.liquid.user.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	public UserDto toDto(UserEntity entity);

	public List<UserDto> toDto(List<UserEntity> entity);

	public UserEntity toEntity(UserDto dto);

	public List<UserEntity> toEntity(List<UserDto> dto);

}
