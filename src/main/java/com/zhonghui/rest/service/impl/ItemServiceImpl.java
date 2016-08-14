package com.zhonghui.rest.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.huizhong.mapper.TbItemMapper;
import com.huizhong.pojo.TbItem;
import com.zhonghui.common.pojo.ZhonghuiResult;
import com.zhonghui.common.utils.JsonUtils;
import com.zhonghui.rest.dao.JedisClient;
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
	@Autowired
	private JedisClient jedisClient;
	@Value("${REDIS_ITEM_KEY}")
	private String REDIS_ITEM_KEY;
	@Value("${REDIS_ITEM_EXPIRE}")
	private Integer REDIS_ITEM_EXPIRE;
	
	@Override
	public ZhonghuiResult getItemBaseInfo(long itemId) {
		// 添加缓存逻辑		
		try {
			// 从缓存中取商品信息，商品id对应的信息
			String key = REDIS_ITEM_KEY + ":" + itemId + ":base";
			String json = jedisClient.get(key);
			// 判断是否有值
			if(!StringUtils.isBlank(json)){
				// 将json转换为java对象
				TbItem item = JsonUtils.jsonToPojo(json, TbItem.class);
				return ZhonghuiResult.ok(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 根据商品id查询商品信息
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		
		try {
			// 把商品信息写入缓存
			String key = REDIS_ITEM_KEY + ":" + itemId + ":base";
			jedisClient.set(key, JsonUtils.objectToJson(item));
			// 设置key的有效期
			jedisClient.expire(key, REDIS_ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 使用ZhonghuiResult包装一下
		return ZhonghuiResult.ok(item);
	}

}
