package com.zhonghui.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huizhong.mapper.TbItemMapper;
import com.huizhong.pojo.TbItem;
import com.zhonghui.common.pojo.ZhonghuiResult;
import com.zhonghui.rest.service.ItemService;
/**
 * 商品信息管理Service
 * @author DELL
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public ZhonghuiResult getItemBaseInfo(long itemId) {
		// 根据商品id查询商品信息
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		// 使用ZhonghuiResult包装一下
		return ZhonghuiResult.ok(item);
	}

}
