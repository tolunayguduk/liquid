package com.liquid.report.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private Long id;
	private String name;
	private String surname;
	private String username;
	private String gender;
	private Date birthDate;
	private int status;
	private Date createDate;
	private String createdBy;
	private Date updateDate;
	private String updatedBy;

}
