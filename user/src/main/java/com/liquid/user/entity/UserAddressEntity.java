package com.liquid.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "USER_ADDRESS")
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private UserEntity user;

	@Column(name = "USER_ID", insertable = false, updatable = false)
	private Long userId;

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

	public void load(UserAddressEntity userAddress) {
		if (userAddress.getCountry() != null)
			this.country = userAddress.getCountry();
		if (userAddress.getCity() != null)
			this.city = userAddress.getCity();
		if (userAddress.getZipCode() != null)
			this.zipCode = userAddress.getZipCode();
		if (userAddress.getAddress() != null)
			this.address = userAddress.getAddress();
		if (userAddress.getUserId() != null)
			this.userId = userAddress.getUserId();
		if (userAddress.getStatus() != null)
			this.status = userAddress.getStatus();
		
	}
}
