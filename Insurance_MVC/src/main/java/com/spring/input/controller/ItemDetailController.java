package com.spring.input.controller;

import java.util.HashMap;

import java.util.Map;

import com.spring.input.logic.Item;
import com.spring.input.logic.Shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemDetailController {

	private Shop shopService;

	public void setShopService(Shop shop) {
		this.shopService = shop;
	}
	
	@RequestMapping
	public ModelAndView detailItem(String itemId){
		// 선택된 상품ID에서 상품 정보를 취득
		Item item = this.shopService.getItemByItemId(itemId);

		// 모델 생성
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("item", item);

		// 반환값인 ModelAndView 인스턴스를 생성
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("itemDetail");
		modelAndView.addAllObjects(model);

		return modelAndView;

	}
	
}