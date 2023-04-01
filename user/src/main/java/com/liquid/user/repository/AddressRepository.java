package com.liquid.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.liquid.user.entity.AddressEntity;

@Repository
public interface AddressRepository  extends JpaRepository<AddressEntity, Long>, RevisionRepository<AddressEntity, Long, Long> {

	Optional<AddressEntity> findOneById(Long id);
	
	Optional<AddressEntity> deleteOneById(Long id);
	
}
