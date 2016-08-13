package com.zhonghui.rest.solrj;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrJTest {
	
	/**
	 * 添加或者修改文档（修改只需要id相同即可）
	 * @throws Exception
	 */
	@Test
	public void addDocument() throws Exception {
		// 创建一个连接
		SolrServer solrServer = new HttpSolrServer("http://192.168.56.128:8080/solr-4.10.3");
		// 创建一个文档对象
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "test001");
		document.addField("item_title", "测试商品1");
		document.addField("item_price", 12345);
		// 把文档对象写入索引库
		solrServer.add(document);
		// 提交
		solrServer.commit();
	}
	
	@Test
	public void deleteDocument() throws Exception {
		// 创建一个连接
		SolrServer solrServer = new HttpSolrServer("http://192.168.56.128:8080/solr-4.10.3");
		// 方法一、按id删除
//		solrServer.deleteById("test001");
		// 方法二、按查询条件删除
		solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}
}
