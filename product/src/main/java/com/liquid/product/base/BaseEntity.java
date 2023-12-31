package com.liquid.product.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "STATUS", nullable = false)
    private Boolean status = true;

    @Column(name = "CREATE_DATE")
    @CreatedDate
    private LocalDateTime createDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATE_DATE")
    @LastModifiedDate
    private LocalDateTime updateDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @PrePersist
    protected void prePersist() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof Jwt) {
            if (this.createdBy == null) createdBy = ((Jwt)principal).getClaimAsString("preferred_username");
        } else {
            if (this.createdBy == null) createdBy = principal.toString();
        }
        if (this.createDate == null) createDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (this.createDate == null) createDate = LocalDateTime.now();
        if (principal instanceof Jwt) {
            if (this.createdBy == null) createdBy = ((Jwt)principal).getClaimAsString("preferred_username");
        } else {
            if (this.createdBy == null) createdBy = principal.toString();
        }
        this.updateDate = LocalDateTime.now();
        if (principal instanceof Jwt) {
            this.updatedBy = ((Jwt)principal).getClaimAsString("preferred_username");
        } else {
            this.updatedBy = principal.toString();
        }
    }

    @PreRemove
    protected void preRemove() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (this.createDate == null) createDate = LocalDateTime.now();
        if (principal instanceof Jwt) {
            if (this.createdBy == null) createdBy = ((Jwt)principal).getClaimAsString("preferred_username");
        } else {
            if (this.createdBy == null) createdBy = principal.toString();
        }
        this.updateDate = LocalDateTime.now();
        if (principal instanceof Jwt) {
            this.updatedBy = ((Jwt)principal).getClaimAsString("preferred_username");
        } else {
            this.updatedBy = principal.toString();
        }
    }
}