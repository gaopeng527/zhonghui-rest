package com.zhonghui.rest.service;

import java.util.List;

import com.huizhong.pojo.TbContent;

public interface ContentService {
	List<TbContent> getContentList(long contentCid);
}
