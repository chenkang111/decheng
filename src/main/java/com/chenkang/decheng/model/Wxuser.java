package com.chenkang.decheng.model;


import lombok.Data;

@Data
public class Wxuser {

	private String openid;
	private String nickname;
	private Integer sex;
	private String province;
	private String city;
	private String headimgurl;
	private String privilege;
	private String unionid;


}