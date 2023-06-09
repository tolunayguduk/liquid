package com.liquid.util.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.liquid.util.entity.GeneralParameterEntity;
import com.liquid.util.exception.Exception;
import com.liquid.util.repository.GeneralParameterRepository;

@Component
public class GeneralParameterService {

	@Autowired
	private static GeneralParameterRepository repository;

	public static List<GeneralParameterEntity> get(String key1) {
		return repository.findByKey1(key1).orElseThrow(() -> Exception.PARAMETER_NOT_FOUND.raise());
	}

	public static List<GeneralParameterEntity> get(String key1, String key2) {
		return repository.findByKey1AndKey2(key1, key2).orElseThrow(() -> Exception.PARAMETER_NOT_FOUND.raise());
	}

	public static GeneralParameterEntity get(String key1, String key2, String key3) {
		return repository.findByKey1andKey2AndKey3(key1, key2, key3).orElseThrow(() -> Exception.PARAMETER_NOT_FOUND.raise());
	}
}
