package com.liquid.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liquid.user.entity.UserEmailEntity;

@Repository
public interface UserEmailRepository extends JpaRepository<UserEmailEntity, Long> {

	Optional<UserEmailEntity> findOneById(Long id);

	Optional<UserEmailEntity> deleteOneById(Long id);

}
