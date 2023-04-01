package com.liquid.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.liquid.user.entity.UserAddressEntity;
import com.liquid.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, RevisionRepository<UserEntity, Long, Long> {

	Optional<UserEntity> findOneById(Long id);

	Optional<UserEntity> deleteOneById(Long id);
	
	Optional<UserEntity> findOneByUsername(String username);

}
