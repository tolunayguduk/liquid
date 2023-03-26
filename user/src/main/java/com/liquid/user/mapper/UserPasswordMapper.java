package com.liquid.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.liquid.user.dto.UserPasswordDto;
import com.liquid.user.entity.UserPasswordEntity;

@Mapper(componentModel = "spring")
public interface UserPasswordMapper {

	UserPasswordMapper INSTANCE = Mappers.getMapper(UserPasswordMapper.class);

	public UserPasswordDto toDto(UserPasswordEntity entity);

	public List<UserPasswordDto> toDto(List<UserPasswordEntity> entity);

	public UserPasswordEntity toEntity(UserPasswordDto dto);

	public List<UserPasswordEntity> toEntity(List<UserPasswordDto> dto);

}
