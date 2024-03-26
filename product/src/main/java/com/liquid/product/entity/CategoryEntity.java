package com.liquid.product.entity;


import com.liquid.product.base.BaseEntity;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CATEGORY")
@AllArgsConstructor
@NoArgsConstructor
@Audited
@AuditTable(value = "CATEGORY_AUDIT")
public class CategoryEntity extends BaseEntity {

	@Column(name = "NAME")
	private String name;

	@Column(name = "OWNER")
	private String owner;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
	private List<ProductEntity> products;

}
