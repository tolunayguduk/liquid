package com.liquid.product.repository;

import com.liquid.product.entity.CatagoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CatagoryEntity, Long>, RevisionRepository<CatagoryEntity, Long, Long> {

	Optional<CatagoryEntity> findOneById(Long id);

	Optional<CatagoryEntity> deleteOneById(Long id);
	
	Optional<List<CatagoryEntity>> findByOwner(String username);

}
