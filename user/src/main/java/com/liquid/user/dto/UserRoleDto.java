package com.liquid.user.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDto {

	private Long userId;
	private Long roleId;
	private int isTemporary;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date expiryDate;
	private int status;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createDate;
	private String createdBy;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updateDate;
	private String updatedBy;

}
