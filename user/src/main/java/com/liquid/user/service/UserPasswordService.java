package com.liquid.user.service;

import com.liquid.user.entity.UserPasswordEntity;
import com.liquid.util.exception.CustomException;

public interface UserPasswordService {

	UserPasswordEntity create(Long userId, UserPasswordEntity password) throws CustomException;;

	UserPasswordEntity update(Long id, UserPasswordEntity password) throws CustomException;;

	void delete(Long id) throws CustomException;;

}
