package com.chenkang.decheng.test;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.model.menu.ClickButton;
import org.weixin4j.model.menu.Menu;
import org.weixin4j.model.menu.SingleButton;
import org.weixin4j.model.menu.ViewButton;
/*
 * 创建菜单*/
@Slf4j
public class MenuDemo {

	public static void main(String[] args) throws WeixinException {
		//创建微信对象
		Weixin weixin = new Weixin();
		//创建按钮对象
		Menu menu = new Menu();
		//创建菜单列表
		List<SingleButton> buttons = new ArrayList<SingleButton>();
		//view菜单
		buttons.add(new ViewButton("个人","http://sate5g.natappfree.cc/yuecheng/api/weixin4j/getCode"));
		//click菜单
		buttons.add(new ClickButton("点我送祝福","button_1"));
		//菜单组
		SingleButton singleButton = new SingleButton("我");
		List<SingleButton> subButtons = new ArrayList<SingleButton>();
		subButtons.add(new ViewButton("个人资料","http://www.baidu.com"));
		subButtons.add(new ClickButton("我的积分","button_3"));
		subButtons.add(new ClickButton("我的主页","button_2"));
		//设置子菜单
		singleButton.setSubButton(subButtons);
		buttons.add(singleButton);
		menu.setButton(buttons);
		//创建菜单
		weixin.menu().create(menu);
		//
		log.info("创建菜单成功");
		log.info(weixin.menu().get().toString());
	}

}
