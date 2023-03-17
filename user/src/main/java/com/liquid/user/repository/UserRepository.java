package com.liquid.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liquid.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findOneById(Long id);

	Optional<UserEntity> deleteOneById(Long id);
	
	Optional<UserEntity> findOneByUsername(String username);

}
