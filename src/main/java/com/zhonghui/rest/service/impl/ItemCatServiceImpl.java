package com.zhonghui.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huizhong.mapper.TbItemCatMapper;
import com.huizhong.pojo.TbItemCat;
import com.huizhong.pojo.TbItemCatExample;
import com.huizhong.pojo.TbItemCatExample.Criteria;
import com.zhonghui.rest.pojo.CatNode;
import com.zhonghui.rest.pojo.CatResult;
import com.zhonghui.rest.service.ItemCatService;
/**
 * 商品分类服务
 * @author DELL
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public CatResult getItemCatList() {
		CatResult catResult = new CatResult();
		// 查询分类列表
		catResult.setData(getCatList(0));
		return catResult;
	}
	
	/**
	 * 查询分类列表
	 * @param parentId
	 * @return
	 */
	private List<?> getCatList(long parentId) {
		// 创建查询条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		// 返回值list
		List resultList = new ArrayList<>();
		// 向list中添加节点
		int count = 0;
		for(TbItemCat tbItemCat : list) {
			// 判断是否为父节点
			if(tbItemCat.getIsParent()) {
				CatNode catNode = new CatNode();
				if(parentId == 0) {
					catNode.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
				} else {
					catNode.setName(tbItemCat.getName());
				}
				catNode.setUrl("/products/"+tbItemCat.getId()+".html");
				catNode.setItem(getCatList(tbItemCat.getId()));
				resultList.add(catNode);
				count++;
				// 限于版面限制，第一层只取14条记录
				if(parentId == 0 && count >= 14) {
					break;
				}
			} else {
				// 叶子节点	
				resultList.add("/products/"+tbItemCat.getId()+".html|"+tbItemCat.getName());
			}
		}
		return resultList;
	}

}
