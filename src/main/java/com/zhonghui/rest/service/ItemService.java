package com.zhonghui.rest.service;

import com.zhonghui.common.pojo.ZhonghuiResult;

public interface ItemService {
	ZhonghuiResult getItemBaseInfo(long itemId);
	ZhonghuiResult getItemDesc(long itemId);
	ZhonghuiResult getItemParam(long itemId);
}
