package com.liquid.user.entity;

import java.util.ArrayList;
import java.util.Date;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "USER")
@AllArgsConstructor
@NoArgsConstructor
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
	private Date birthDate;

	@Column(name = "STATUS")
	private int status;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", targetEntity = UserEmailEntity.class)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<UserEmailEntity> emails = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", targetEntity = UserAddressEntity.class)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<UserAddressEntity> addresses = new ArrayList<>();
}
