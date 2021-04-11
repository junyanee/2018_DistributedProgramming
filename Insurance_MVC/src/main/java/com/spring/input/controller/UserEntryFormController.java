package com.spring.input.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.input.logic.Shop;
import com.spring.input.logic.User;
import com.spring.input.utils.UserEntryValidator;

@Controller
public class UserEntryFormController {

	private UserEntryValidator userEntryValidator;
	
	private Shop shopService;

	private MessageSource messageSource;
	
	
	public void setUserEntryValidator(UserEntryValidator userEntryValidator) {
		this.userEntryValidator = userEntryValidator;
	}

	public void setShopService(Shop shop) {
		this.shopService = shop;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String toUserEntryView() {
		return "userEntry";
	}

	@ModelAttribute
	public User setUpForm() {
		User user = new User();
		MessageSourceAccessor accessor = new MessageSourceAccessor(this.messageSource);
		return user;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult bindingResult) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}

		try {
			this.shopService.entryUser(user);
			modelAndView.setViewName("userEntrySuccess");
			modelAndView.addObject("user", user);
			return modelAndView;

		} catch (Exception e) {
			// 유저ID가 중복일 때, 폼 송신처로 이동
			bindingResult.reject("error.duplicate.user");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
			
		}
	}
}