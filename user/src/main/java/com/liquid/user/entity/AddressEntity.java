package com.liquid.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ADDRESS")
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "CITY")
	private String city;

	@Column(name = "ZIP_CODE")
	private String zipCode;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "STATUS")
	private Boolean status;

	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATE_DATE")
	private LocalDateTime updateDate;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	public void load(AddressEntity entity) {
		if (entity.getCountry() != null)
			this.country = entity.getCountry();
		if (entity.getCity() != null)
			this.city = entity.getCity();
		if (entity.getZipCode() != null)
			this.zipCode = entity.getZipCode();
		if (entity.getAddress() != null)
			this.address = entity.getAddress();
		if (entity.getStatus() != null)
			this.status = entity.getStatus();
	}

}