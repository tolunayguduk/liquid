package com.liquid.util.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.liquid.util.entity.GeneralParameterEntity;
import com.liquid.util.exception.Exception;
import com.liquid.util.repository.GeneralParameterRepository;

public class GeneralParameterService {

	@Autowired
	private GeneralParameterRepository repository;

	public List<GeneralParameterEntity> get(String key1) {
		return repository.findByKey1(key1).orElseThrow(() -> Exception.PARAMETER_NOT_FOUND.raise());
	}

	@Autowired
	public List<GeneralParameterEntity> get(String key1, String key2) {
		return repository.findByKey1AndKey2(key1, key2).orElseThrow(() -> Exception.PARAMETER_NOT_FOUND.raise());
	}

	@Autowired
	public GeneralParameterEntity get(String key1, String key2, String key3) {
		return repository.findByKey1andKey2AndKey3(key1, key2, key3).orElseThrow(() -> Exception.PARAMETER_NOT_FOUND.raise());
	}
}
