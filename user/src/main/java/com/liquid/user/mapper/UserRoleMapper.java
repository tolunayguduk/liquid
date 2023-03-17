package com.liquid.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.liquid.user.dto.UserRoleDto;
import com.liquid.user.entity.UserRoleEntity;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

	UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);

	public UserRoleDto toDto(UserRoleEntity entity);

	public List<UserRoleDto> toDto(List<UserRoleEntity> entity);

	public UserRoleEntity toEntity(UserRoleDto dto);

	public List<UserRoleEntity> toEntity(List<UserRoleDto> dto);

}
