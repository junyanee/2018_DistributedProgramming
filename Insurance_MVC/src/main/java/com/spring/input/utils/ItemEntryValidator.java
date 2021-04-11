package com.spring.input.utils;

import com.spring.input.logic.Item;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ItemEntryValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Item.class.isAssignableFrom(clazz);
	}

	public void validate(Object command, Errors errors) {

		Item user = (Item) command;

		if (!StringUtils.hasLength(user.getItemId())) {
			errors.rejectValue("itemId", "error.required");
		}

		if (!StringUtils.hasLength(user.getItemId())) {
			errors.rejectValue("ItemName", "error.required");
		}

		if (!StringUtils.hasText(user.getDescription())) {
			errors.rejectValue("description", "error.required");
		}

		if (errors.hasErrors()) {
			errors.reject("error.input.user");
		}
	}
}
