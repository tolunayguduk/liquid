package com.liquid.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liquid.user.entity.UserPasswordEntity;

@Repository
public interface UserPasswordRepository extends JpaRepository<UserPasswordEntity, Long> {

	Optional<UserPasswordEntity> findOneById(Long id);

	Optional<UserPasswordEntity> deleteOneById(Long id);

}
