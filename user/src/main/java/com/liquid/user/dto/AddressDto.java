package com.liquid.user.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

	private Long id;
	private String country;
	private String city;
	private String zipCode;
	private String address;
	private Boolean status;
	private LocalDateTime createDate;
	private String createdBy;
	private LocalDateTime updateDate;
	private String updatedBy;
}
