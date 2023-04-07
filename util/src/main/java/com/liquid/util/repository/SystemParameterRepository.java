package com.liquid.util.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liquid.util.entity.SystemParameterEntity;

public interface SystemParameterRepository extends JpaRepository<SystemParameterEntity, Long> {

	Optional<SystemParameterEntity> findOneById(Long id);

	Optional<List<SystemParameterEntity>> findByKey1(String key1);

	Optional<List<SystemParameterEntity>> findByKey1AndKey2(String key1, String key2);

	Optional<SystemParameterEntity> findByKey1andKey2AndKey3(String key1, String key2, String key3);

	Optional<SystemParameterEntity> deleteOneById(Long id);

}
