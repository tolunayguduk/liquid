package com.liquid.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liquid.user.entity.UserRoleEntity;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

	Optional<List<UserRoleEntity>> findByUserId(Long userId);

	Optional<UserRoleEntity> findOneById(Long id);

	Optional<UserRoleEntity> findOneByUserIdAndRoleId(Long userId, Long roleId);

	Optional<UserRoleEntity> deleteOneById(Long id);

}
