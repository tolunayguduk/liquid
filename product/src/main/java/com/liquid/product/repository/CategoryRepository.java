package com.liquid.product.repository;

import com.liquid.product.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>, RevisionRepository<CategoryEntity, Long, Long> {

	Optional<CategoryEntity> findOneById(Long id);

	Optional<CategoryEntity> deleteOneById(Long id);
	
	Optional<List<CategoryEntity>> findByOwner(String username);

}
