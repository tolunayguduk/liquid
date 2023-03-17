package com.liquid.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.liquid.user.dto.RoleDto;
import com.liquid.user.entity.RoleEntity;

@Mapper(componentModel = "spring")
public interface RoleMapper {

	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

	public RoleDto toDto(RoleEntity entity);

	public List<RoleDto> toDto(List<RoleEntity> entity);

	public RoleEntity toEntity(RoleDto dto);

	public List<RoleEntity> toEntity(List<RoleDto> dto);

}
