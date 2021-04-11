package com.spring.input.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.input.logic.Item;
import com.spring.input.logic.Shop;
import com.spring.input.utils.ItemEntryValidator;

@Controller
public class ItemEntryFormController {

	private ItemEntryValidator itemEntryValidator;
	private Shop shopService;
	private MessageSource messageSource;

	public void setItemEntryValidator(ItemEntryValidator itemEntryValidator) {
		this.itemEntryValidator = itemEntryValidator;
	}
	public void setShopService(Shop shop) {
		this.shopService = shop;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String toItemEntryView() {
		return "itemEntry";
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(Item item, BindingResult bindingResult) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
		try {
			this.shopService.entryItem(item);
			modelAndView.setViewName("itemEntrySuccess");
			modelAndView.addObject("item", item);
			return modelAndView;
		} catch (Exception e) {
			// 상품ID가 중복일 때, 폼 송신처로 이동
			bindingResult.reject("error.duplicate.list");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
	}
}