package com.zhonghui.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
/**
 * 商品分类列表
 * @author DELL
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonghui.common.utils.JsonUtils;
import com.zhonghui.rest.pojo.CatResult;
import com.zhonghui.rest.service.ItemCatService;
@Controller
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	/*@RequestMapping(value="/itemcat/list", 
			produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback) {
		CatResult catResult = itemCatService.getItemCatList();
		// 把pojo转换成字符串
		String json = JsonUtils.objectToJson(catResult);
		// 拼装返回值
		String result = callback + "(" + json + ");";
		return result;
	}*/
	
	// 另一种实现方式，要求spring版本在4.1及其以上
	@RequestMapping("/itemcat/list")
	@ResponseBody
	public Object getItemCatList(String callback) {
		CatResult catResult = itemCatService.getItemCatList();
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	}
}
