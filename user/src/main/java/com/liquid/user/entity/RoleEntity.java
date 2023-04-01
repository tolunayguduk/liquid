package com.liquid.user.entity;

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
@Table(name = "ROLE")
@AllArgsConstructor
@NoArgsConstructor
@Audited
@AuditTable(value = "ROLE_AUDIT")
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role", targetEntity = UserRoleEntity.class)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<UserRoleEntity> userRoles = new ArrayList<>();
	
	public void load(RoleEntity entity) {
		if (entity.getName() != null)
			this.name = entity.getName();
		if (entity.getDescription() != null)
			this.description = entity.getDescription();
		if (entity.getStatus() != null)
			this.status = entity.getStatus();
	}
}
