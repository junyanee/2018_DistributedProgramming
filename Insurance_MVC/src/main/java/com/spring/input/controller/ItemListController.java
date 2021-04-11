package com.spring.input.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.input.logic.Item;
import com.spring.input.logic.Shop;

public class ItemListController implements Controller {

	private Shop shopService;

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {


		ArrayList<Item> itemList = this.shopService.getItemList();

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList", itemList);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("itemList");
		modelAndView.addAllObjects(model);

		return modelAndView;
	}
}