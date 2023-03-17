package com.liquid.user.dto;

import java.util.Date;

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
	private Date expiryDate;
	private int status;
	private Date createDate;
	private String createdBy;
	private Date updateDate;
	private String updatedBy;

}
