package com.zhonghui.rest.service;

import com.zhonghui.common.pojo.ZhonghuiResult;

public interface RedisService {
	ZhonghuiResult syncContent(long contentCid);
}
