package com.liquid.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.liquid.user.dto.EmailDto;
import com.liquid.user.entity.UserEmailEntity;

@Mapper(componentModel = "spring")
public interface EmailMapper {

	EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

	public EmailDto toDto(UserEmailEntity entity);

	public List<EmailDto> toDto(List<UserEmailEntity> entity);

	public UserEmailEntity toEntity(EmailDto dto);

	public List<UserEmailEntity> toEntity(List<EmailDto> dto);
}
