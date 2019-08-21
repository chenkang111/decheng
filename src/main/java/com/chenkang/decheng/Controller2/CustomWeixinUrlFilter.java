/**
 * 
 */
package com.chenkang.decheng.Controller2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.weixin4j.Configuration;
import org.weixin4j.util.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/api/weixin4j")
@Slf4j
public class CustomWeixinUrlFilter {
	@RequestMapping(method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //微信服务器将发送GET请求到填写的URL上,这里需要判定是否为GET请求
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        if (Configuration.isDebug()) {
         log.info("正常验证请求，请求地址：{}",request.getRequestURI());
        }
        //消息来源可靠性验证
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");       // 随机数
        //Token为weixin4j.properties中配置的Token
        String token = TokenUtil.get();
        log.info("微信加密签名：{}，时间戳：{}，随机数：{}，配置token:{}",signature,timestamp,nonce,token);
        //1.验证消息真实性
        //http://mp.weixin.qq.com/wiki/index.php?title=验证消息真实性
        //URL为http://www.weixin4j.org/api/公众号
        //成为开发者验证
        String echostr = request.getParameter("echostr");   //
        //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
        if (TokenUtil.checkSignature(token, signature, timestamp, nonce)) {
            response.getWriter().write(echostr);
        }
    }
	

	

}
