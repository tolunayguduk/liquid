package com.liquid.user.dto;

import java.time.LocalDateTime;

import com.liquid.user.entity.AddressEntity;
import com.liquid.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressDto {

	private Long id;
	private AddressEntity address;
	private UserEntity user;
	private Long userId;
	private Boolean status;
	private LocalDateTime createDate;
	private String createdBy;
	private LocalDateTime updateDate;
	private String updatedBy;

}
