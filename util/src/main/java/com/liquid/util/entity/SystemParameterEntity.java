package com.liquid.util.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "SYSTEM_PARAMETER")
@AllArgsConstructor
@NoArgsConstructor
@Audited
@AuditTable(value = "SYSTEM_PARAMETER_AUDIT")
public class SystemParameterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "KEY1")
	private String key1;

	@Column(name = "KEY2")
	private String key2;

	@Column(name = "KEY3")
	private String key3;

	@Column(name = "VALUE")
	private String value;

	@Column(name = "DESCRIPTION")
	private Boolean description;

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

}
