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
	
	@RequestMapping("/info/{itemId}")
	@ResponseBody
	public ZhonghuiResult getItemBaseInfo(@PathVariable Long itemId){
		ZhonghuiResult result = itemService.getItemBaseInfo(itemId);
		return result;
	}
}
