package com.chenkang.decheng.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.model.media.Article;
import org.weixin4j.model.message.Articles;
import org.weixin4j.model.message.MediaType;

/**
 * 素材上传类相关
 * */
public class FileDemo {
	public static void main(String [] str) throws WeixinException{
		Weixin weixin = new Weixin();
		File file = new File("F:/xy1.jpg");
		
		//String mediaId = weixin.media().upload(MediaType.Image,file);
		Article article_1  =new Article();
		article_1.setAuthor("许洋");
		article_1.setContent("仅仅是测试用haaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaahahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		article_1.setContent_source_url("http://www.baidu.com");
		article_1.setDigest("");
		article_1.setTitle("测试");
		article_1.setShow_cover_pic(1);
		article_1.setThumb_media_id("4eEfQwAH_BHb2p2Z_U8AQ0Qr5STDrfo-GSMB7xfGHHFa7DE7e89ONNO1K4ZejimX");
		List<Article> articles =new ArrayList<Article>();
		articles.add(article_1);
		String mediaId =weixin.media().uploadnews(articles);
		System.out.println(mediaId);
		
	}

}
