package com.chenkang.decheng.test;

import java.util.ArrayList;
import java.util.List;

import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.model.message.Articles;
import org.weixin4j.model.message.template.TemplateData;

/**
 * 获得关注者信息
 * */
public class FollowerDemo {
	public static void main(String [] str) throws WeixinException{
		Weixin weixin = new Weixin();
		//发送消息给关注者
		String [] openids = {"o01En07ej1LEbZ9c-QTc_kn94wLs","o01En0_RA_-C0UagTPWpC1UVM_dM"};
		weixin.message().massSendContent(openids, "邵硕，在吗？问你个事，你公众号是在用户关注的时候获取到的用户信息然后存入数据库的吗");
	/*	Articles article_1  =new Articles();
		article_1.setDescription("测试");
		article_1.setTitle("测试");
		article_1.setPicUrl("rHvgi0TEv-tpx2XcMqA7IUHTAOb4jINBlPCV3fG8URBMOMpoxiCnxkhIcgfx6lTi");
		article_1.setPicurl("rHvgi0TEv-tpx2XcMqA7IUHTAOb4jINBlPCV3fG8URBMOMpoxiCnxkhIcgfx6lTi");
		article_1.setUrl("rHvgi0TEv-tpx2XcMqA7IUHTAOb4jINBlPCV3fG8URBMOMpoxiCnxkhIcgfx6lTi");
		List<Articles> articles =new ArrayList<Articles>();
		articles.add(article_1);
		//发送模板消息
		weixin.message().customSendNews("o01En0_RA_-C0UagTPWpC1UVM_dM", articles);*/
		/*TemplateData td = new TemplateData();
		td.setColor("#FF0000");
		td.setKey("");
		td.setValue("");
		List<TemplateData> datas =new ArrayList<TemplateData>();
		datas.add(td);
		weixin.message().sendTemplateMessage("o01En09rFphAB7yfbbPwy_1KG7vY", "E-XSM2MvdGlCSzvlZOl4MbtJuOskcuhv_XgfoHu976w", datas);*/
		
	}
	

}
