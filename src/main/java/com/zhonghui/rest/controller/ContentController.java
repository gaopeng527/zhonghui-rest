package com.zhonghui.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huizhong.pojo.TbContent;
import com.zhonghui.common.pojo.ZhonghuiResult;
import com.zhonghui.common.utils.ExceptionUtil;
import com.zhonghui.rest.service.ContentService;
/**
 * 内容管理Controller
 * @author DELL
 *
 */
@Controller
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/list/{contentCategoryId}")
	@ResponseBody
	public ZhonghuiResult getContentList(@PathVariable Long contentCategoryId) {
		try {
			List<TbContent> result = contentService.getContentList(contentCategoryId);
			return ZhonghuiResult.ok(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ZhonghuiResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
