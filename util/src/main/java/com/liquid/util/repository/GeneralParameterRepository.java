package com.liquid.util.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liquid.util.entity.GeneralParameterEntity;

public interface GeneralParameterRepository extends JpaRepository<GeneralParameterEntity, Long> {

	Optional<GeneralParameterEntity> findOneById(Long id);

	Optional<List<GeneralParameterEntity>> findByKey1(String key1);

	Optional<List<GeneralParameterEntity>> findByKey1AndKey2(String key1, String key2);

	Optional<GeneralParameterEntity> findByKey1andKey2AndKey3(String key1, String key2, String key3);

	Optional<GeneralParameterEntity> deleteOneById(Long id);

}
