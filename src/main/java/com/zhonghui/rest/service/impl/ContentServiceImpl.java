package com.zhonghui.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huizhong.mapper.TbContentMapper;
import com.huizhong.pojo.TbContent;
import com.huizhong.pojo.TbContentExample;
import com.huizhong.pojo.TbContentExample.Criteria;
import com.zhonghui.rest.service.ContentService;
/**
 * 内容管理
 * @author DELL
 *
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Override
	public List<TbContent> getContentList(long contentCid) {
		// 根据内容分类id查询内容列表
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(contentCid);
		// 执行查询
		List<TbContent> list = contentMapper.selectByExample(example);
		return list;
	}

}
