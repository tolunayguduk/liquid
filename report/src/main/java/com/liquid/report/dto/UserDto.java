package com.liquid.report.dto;

import java.util.Date;

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

	public UserDto(Long id, String name, String surname, String username, String gender, Date birthDate, int status, Date createDate, String createdBy, Date updateDate, String updatedBy) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.gender = gender;
		this.birthDate = birthDate;
		this.status = status;
		this.createDate = createDate;
		this.createdBy = createdBy;
		this.updateDate = updateDate;
		this.updatedBy = updatedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
