package com.liquid.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.liquid.user.entity.UserEmailEntity;

@Repository
public interface UserEmailRepository extends JpaRepository<UserEmailEntity, Long>, RevisionRepository<UserEmailEntity, Long, Long> {

	Optional<List<UserEmailEntity>> findByUserId(Long userId);
	
	Optional<UserEmailEntity> findOneById(Long id);

	Optional<UserEmailEntity> deleteOneById(Long id);

}
