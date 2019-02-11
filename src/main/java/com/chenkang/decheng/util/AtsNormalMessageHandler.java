package com.chenkang.decheng.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.model.message.OutputMessage;
import org.weixin4j.model.message.normal.ImageInputMessage;
import org.weixin4j.model.message.normal.LinkInputMessage;
import org.weixin4j.model.message.normal.LocationInputMessage;
import org.weixin4j.model.message.normal.ShortVideoInputMessage;
import org.weixin4j.model.message.normal.TextInputMessage;
import org.weixin4j.model.message.normal.VideoInputMessage;
import org.weixin4j.model.message.normal.VoiceInputMessage;
import org.weixin4j.model.message.output.TextOutputMessage;
import org.weixin4j.spi.INormalMessageHandler;

/**
 * 自定义消息处理类*/

public class AtsNormalMessageHandler implements INormalMessageHandler  {
	
	protected final Logger LOG = LoggerFactory.getLogger(AtsNormalMessageHandler.class);

	public OutputMessage imageTypeMsg(ImageInputMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的图片消息已经收到！");
        return out;
	}

	public OutputMessage linkTypeMsg(LinkInputMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的链接消息已经收到！");
        return out;
	}

	public OutputMessage locationTypeMsg(LocationInputMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的本地图片已经收到！");
        return out;
	}

	public OutputMessage shortvideoTypeMsg(ShortVideoInputMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的短视频已经收到！");
        return out;
	}

	public OutputMessage textTypeMsg(TextInputMessage msg) {
		LOG.debug("文本消息：" + msg.getContent());
		System.out.println(msg.getFromUserName()+","+msg.getContent());
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("您发的消息是：" + msg.getContent());
		return out;
	}

	public OutputMessage videoTypeMsg(VideoInputMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的视频已经收到！"+msg.getMediaId());
        return out;
	}

	public OutputMessage voiceTypeMsg(VoiceInputMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的语音已经收到！");
        return out;
	}

}
