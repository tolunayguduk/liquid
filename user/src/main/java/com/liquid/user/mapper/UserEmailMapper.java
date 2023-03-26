package com.liquid.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.liquid.user.dto.UserEmailDto;
import com.liquid.user.entity.UserEmailEntity;

@Mapper(componentModel = "spring")
public interface UserEmailMapper {

	UserEmailMapper INSTANCE = Mappers.getMapper(UserEmailMapper.class);

	public UserEmailDto toDto(UserEmailEntity entity);

	public List<UserEmailDto> toDto(List<UserEmailEntity> entity);

	public UserEmailEntity toEntity(UserEmailDto dto);

	public List<UserEmailEntity> toEntity(List<UserEmailDto> dto);
}
