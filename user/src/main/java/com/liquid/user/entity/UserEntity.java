package com.liquid.user.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "USER")
@AllArgsConstructor
@NoArgsConstructor
@Audited
@AuditTable(value = "USER_AUDIT")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "PROFILE_PHOTO_LINK")
	private String profilePhotoLink;

	@Column(name = "BIRTH_DATE")
	private LocalDate birthDate;

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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", targetEntity = UserEmailEntity.class)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<UserEmailEntity> emails = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", targetEntity = UserAddressEntity.class)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<UserAddressEntity> userAddresses = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", targetEntity = UserRoleEntity.class)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<UserRoleEntity> userRoles = new ArrayList<>();

	public void load(UserEntity user) {
		if(user.getName() != null)
			this.name = user.getName();
		if(user.getSurname() != null)
			this.surname = user.getSurname();
		if(user.getUsername() != null)
			this.username = user.getUsername();
		if(user.getGender() != null)
			this.gender = user.getGender();
		if(user.getProfilePhotoLink() != null)
			this.profilePhotoLink = user.getProfilePhotoLink();
		if(user.getBirthDate() != null)
			this.birthDate = user.getBirthDate();
		if(user.getStatus() != null)
			this.status = user.getStatus();
	}
}
