package com.liquid.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liquid.user.entity.UserAddressEntity;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Long>{

	Optional<UserAddressEntity> findOneById(Long id);
	
	Optional<UserAddressEntity> findOneByUserIdAndAddressId(Long userId, Long addressId);
	
	Optional<UserAddressEntity> deleteOneById(Long id);
	
}
