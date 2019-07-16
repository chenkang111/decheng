package com.chenkang.decheng.util.qydemo;

import com.alibaba.fastjson.JSONObject;
import com.chenkang.decheng.common.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;

//获取AccessToken
@Slf4j
public class GetAccessToken {

    public static String token_url="https://qyapi.weixin.qq.com/cgi-bin/gettoken";

    public static String getToken(){
        JSONObject result=HttpUtils.httpsRequest(buildurl(Constant.corid,Constant.txl_secret),"GET",null);
        log.info(result.toString());
        if(result.getIntValue("errcode")==0){
            //可以存储redis  设置失效实现为7200秒时间可以少些
           String token=result.getString("access_token");
           log.info(token);
           return token;
        }
        return null;
    }

    public static void main(String[] args) {
        getToken();
    }


    public static String buildurl(String corpid,String corpsecret){
      return   String.format(token_url+"?corpid=%s&corpsecret=%s",corpid,corpsecret);
    }



}
