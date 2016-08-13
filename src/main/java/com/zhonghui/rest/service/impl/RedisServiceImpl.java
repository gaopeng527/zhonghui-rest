package com.zhonghui.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zhonghui.common.pojo.ZhonghuiResult;
import com.zhonghui.common.utils.ExceptionUtil;
import com.zhonghui.rest.dao.JedisClient;
import com.zhonghui.rest.service.RedisService;
/**
 * 缓存同步Service
 * @author DELL
 *
 */
@Service
public class RedisServiceImpl implements RedisService {
	
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	@Override
	public ZhonghuiResult syncContent(long contentCid) {
		try {
			jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, contentCid+"");
		} catch (Exception e) {
			return ZhonghuiResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return ZhonghuiResult.ok();
	}

}
