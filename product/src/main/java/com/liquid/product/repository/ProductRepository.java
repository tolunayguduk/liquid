package com.liquid.product.repository;

import com.liquid.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>, RevisionRepository<ProductEntity, Long, Long> {

    Optional<ProductEntity> findOneById(Long id);

    Optional<ProductEntity> deleteOneById(Long id);

    Optional<List<ProductEntity>> findByOwner(String username);

    Optional<List<ProductEntity>> findByOwnerAndCategoryId(String username, Long categoryId);

    Optional<List<ProductEntity>> findByCategoryId(Long categoryId);

}
