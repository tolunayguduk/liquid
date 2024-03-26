package com.liquid.product.entity;

import com.liquid.product.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Audited
@AuditTable(value = "PRODUCT_AUDIT")
public class ProductEntity extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "IMAGE_LINK")
    private String imageLink;

    @Column(name = "OWNER")
    private String owner;

}
