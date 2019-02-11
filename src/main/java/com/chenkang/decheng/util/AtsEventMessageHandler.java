/**
 * 
 */
package com.chenkang.decheng.util;

import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.component.MediaComponent;
import org.weixin4j.model.message.Image;
import org.weixin4j.model.message.OutputMessage;
import org.weixin4j.model.message.event.ClickEventMessage;
import org.weixin4j.model.message.event.LocationEventMessage;
import org.weixin4j.model.message.event.LocationSelectEventMessage;
import org.weixin4j.model.message.event.PicPhotoOrAlbumEventMessage;
import org.weixin4j.model.message.event.PicSysPhotoEventMessage;
import org.weixin4j.model.message.event.PicWeixinEventMessage;
import org.weixin4j.model.message.event.QrsceneScanEventMessage;
import org.weixin4j.model.message.event.QrsceneSubscribeEventMessage;
import org.weixin4j.model.message.event.ScanCodePushEventMessage;
import org.weixin4j.model.message.event.ScanCodeWaitMsgEventMessage;
import org.weixin4j.model.message.event.SubscribeEventMessage;
import org.weixin4j.model.message.event.UnSubscribeEventMessage;
import org.weixin4j.model.message.event.ViewEventMessage;
import org.weixin4j.model.message.output.ImageOutputMessage;
import org.weixin4j.model.message.output.TextOutputMessage;
import org.weixin4j.spi.IEventMessageHandler;

/**
 * 
 * 自定义事件消息处理器
 *
 *
 */
public class AtsEventMessageHandler implements IEventMessageHandler {

	public OutputMessage click(ClickEventMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
		ImageOutputMessage msgOut = new ImageOutputMessage();
		Image image = new Image();
		image.setMediaId("CL1iVIP19aSUBzdRX1cJONe7ZM16DpAsMMks8SqV5OUfCBRIAoKUULo_r67NSGS5");
		if(msg.getEventKey().equals("button_1")){
			msgOut.setImage(image);
			return msgOut;
		}else if(msg.getEventKey().equals("button_2")){
			Image image1 = new Image();
			image1.setMediaId("4eEfQwAH_BHb2p2Z_U8AQ0Qr5STDrfo-GSMB7xfGHHFa7DE7e89ONNO1K4ZejimX");
			msgOut.setImage(image1);
			return msgOut;
		}else if(msg.getEventKey().equals("button_3")){
			out.setContent("这是你的积分！");
		}else{
			out.setContent("你点了什么！");
		}
		
        
        return out;
	}

	public OutputMessage location(LocationEventMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的位置消息已经收到！");
        return out;
	}

	public OutputMessage locationSelect(LocationSelectEventMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("选择地理位置！");
        return out;
	}

	public OutputMessage picPhotoOrAlbum(PicPhotoOrAlbumEventMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("选择相册！");
        return out;
	}

	public OutputMessage picSysPhoto(PicSysPhotoEventMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("发起拍照！");
        return out;
	}

	public OutputMessage picWeixin(PicWeixinEventMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("上传图片！");
        return out;
	}

	public OutputMessage qrsceneScan(QrsceneScanEventMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
	}

	public OutputMessage qrsceneSubscribe(QrsceneSubscribeEventMessage msg) {
		
		 TextOutputMessage out = new TextOutputMessage();
        out.setContent("感谢您的关注！，来源：" + msg.getEventKey());
        return out;
	}

	public OutputMessage scanCodePush(ScanCodePushEventMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("扫码！");
        return out;
	}

	public OutputMessage scanCodeWaitMsg(ScanCodeWaitMsgEventMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("扫码等待中！");
        return out;
	}
	
	public OutputMessage subscribe(SubscribeEventMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
        out.setContent("感谢您关注了我！");
        return out;
	}

	public OutputMessage unSubscribe(UnSubscribeEventMessage msg) {
		//取消关注
        return null;
	}

	public OutputMessage view(ViewEventMessage msg) {
		 TextOutputMessage out = new TextOutputMessage();
	        out.setContent("点击了链接！");
	        return out;
	}

}
