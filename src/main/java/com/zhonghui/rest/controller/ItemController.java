package com.zhonghui.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonghui.common.pojo.ZhonghuiResult;
import com.zhonghui.rest.service.ItemService;
/**
 * 商品信息Controller
 * @author DELL
 *
 */
@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	// 商品基本信息
	@RequestMapping("/info/{itemId}")
	@ResponseBody
	public ZhonghuiResult getItemBaseInfo(@PathVariable Long itemId){
		ZhonghuiResult result = itemService.getItemBaseInfo(itemId);
		return result;
	}
	
	// 商品描述信息
	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public ZhonghuiResult getItemDesc(@PathVariable Long itemId){
		ZhonghuiResult result = itemService.getItemDesc(itemId);
		return result;
	}
	
	// 商品规格信息
	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public ZhonghuiResult getItemParam(@PathVariable Long itemId){
		ZhonghuiResult result = itemService.getItemParam(itemId);
		return result;
	}
}
