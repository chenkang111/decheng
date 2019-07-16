package com.chenkang.decheng.controller;

import com.chenkang.decheng.model.Wxuser;
import com.chenkang.decheng.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.model.sns.SnsUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 获取微信授权
 */
@Controller
@RequestMapping("/api/weixin4j")
public class SnsController {
	@Autowired
	private WxUserService wxUserService;
	// 创建微信对象
	Weixin weixin = new Weixin();

	// 换取code
	@RequestMapping("/getCode")
	public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = weixin.sns()
				.getOAuth2CodeUserInfoUrl("http://sate5g.natappfree.cc/yuecheng/api/weixin4j/getTaken");
		System.out.println(url);
		response.sendRedirect(url);
	}

	// 换取个人信息
	@PostMapping("/getTaken")
	public void getTaken(HttpServletRequest request, HttpServletResponse response) throws IOException, WeixinException {
		String code = request.getParameter("code");
		System.out.println("code:" + code);
		SnsUser user = weixin.sns().getSnsUserByCode(code, "zh_CN");
		System.out.println("用户信息：" + user);
		// 插入用户信息
		if (null != user && !user.equals("")) {
			String openid = user.getOpenid();
			Wxuser wxuser1 = new Wxuser();
			wxuser1.setCity(user.getCity());
			wxuser1.setHeadimgurl(user.getHeadimgurl());
			wxuser1.setNickname(user.getNickname());
			wxuser1.setOpenid(user.getOpenid());
			wxuser1.setPrivilege(user.getPrivilege().toString());
			wxuser1.setProvince(user.getProvince());
			wxuser1.setSex(user.getSex());
			wxuser1.setUnionid(user.getUnionid());
			if (wxUserService.selectById(openid)==null) {
				wxUserService.insert(wxuser1);
				System.out.println("用户已插入数据库");
			} else {
				System.out.println("用户已存在数据库");
			}
			response.sendRedirect("http://sate5g.natappfree.cc/yuecheng/login");
		}

	}
}
