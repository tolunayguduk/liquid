package com.liquid.user.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressDto {

	private Long id;
	private Long userId;
	private String country;
	private String city;
	private String zipCode;
	private String address;
	private Boolean status;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createDate;
	private String createdBy;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updateDate;
	private String updatedBy;

}
