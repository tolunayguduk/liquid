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
@Table(name = "USER_PASSWORD")
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private UserEntity user;

	@Column(name = "USER_ID", insertable = false, updatable = false)
	private Long userId;

	@Column(name = "PASSWORD")
	private String password;

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

	public void load(UserPasswordEntity userPassword) {
		if (userPassword.getPassword() != null)
			this.password = userPassword.getPassword();
		if (userPassword.getUserId() != null)
			this.userId = userPassword.getUserId();
		if (userPassword.getStatus() != null)
			this.status = userPassword.getStatus();
	}
}
