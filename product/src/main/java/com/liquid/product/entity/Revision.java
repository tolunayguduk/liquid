package com.liquid.product.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;

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
