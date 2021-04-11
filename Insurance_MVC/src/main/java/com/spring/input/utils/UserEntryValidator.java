package com.spring.input.utils;

import com.spring.input.logic.User;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserEntryValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object command, Errors errors) {

		User user = (User) command;

		if (!StringUtils.hasLength(user.getUserId())) {
			errors.rejectValue("userId", "error.required");
		}

		if (!StringUtils.hasLength(user.getAge())) {
			errors.rejectValue("age", "error.required");
		}

		if (!StringUtils.hasLength(user.getUserName())) {
			errors.rejectValue("userName", "error.required");
		}

		if (!StringUtils.hasText(user.getSsn())) {
			errors.rejectValue("ssn", "error.required");
		}

		if (!StringUtils.hasText(user.getAddress())) {
			errors.rejectValue("address", "error.required");
		}

		if (!StringUtils.hasText(user.getEmail())) {
			errors.rejectValue("email", "error.required");
		}

		if (errors.hasErrors()) {
			// �삤瑜섍� �엳�쑝硫�, 硫붿떆吏� �엯�젰 �삤瑜� 硫붿떆吏� 異붽�
			errors.reject("error.input.user");
		}
	}
}
