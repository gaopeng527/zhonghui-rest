package com.zhonghui.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonghui.common.pojo.ZhonghuiResult;
import com.zhonghui.rest.service.RedisService;

/**
 * 缓存同步Controller
 * @author DELL
 *
 */
@Controller
@RequestMapping("/cache/sync")
public class RedisController {
	
	@Autowired
	private RedisService redisService;
	
	@RequestMapping("/content/{contentCid}")
	@ResponseBody
	public ZhonghuiResult contentCacheSync(@PathVariable Long contentCid) {
		ZhonghuiResult result = redisService.syncContent(contentCid);
		return result;
	}
}
