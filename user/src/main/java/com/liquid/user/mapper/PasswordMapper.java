package com.liquid.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.liquid.user.dto.PasswordDto;
import com.liquid.user.entity.UserPasswordEntity;

@Mapper(componentModel = "spring")
public interface PasswordMapper {

	PasswordMapper INSTANCE = Mappers.getMapper(PasswordMapper.class);

	public PasswordDto toDto(UserPasswordEntity entity);

	public List<PasswordDto> toDto(List<UserPasswordEntity> entity);

	public UserPasswordEntity toEntity(PasswordDto dto);

	public List<UserPasswordEntity> toEntity(List<PasswordDto> dto);

}
