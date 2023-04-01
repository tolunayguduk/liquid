package com.liquid.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@RevisionEntity
@Table( name = "REVISION")
@AllArgsConstructor
@NoArgsConstructor
public class Revision {

	@Id
	@Column(name = "REV")
	@RevisionNumber
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rev;

	@Column(name = "REVTSTMP")
	@RevisionTimestamp
	private Long revtstmp;
	
}
