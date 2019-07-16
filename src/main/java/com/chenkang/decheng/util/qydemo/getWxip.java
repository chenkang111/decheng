package com.chenkang.decheng.util.qydemo;

import com.alibaba.fastjson.JSONObject;
import com.chenkang.decheng.common.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class getWxip {



    public static  final String callbackip_url="https://qyapi.weixin.qq.com/cgi-bin/getcallbackip?access_token=%s";

    public static  final String Access_token="azCtFcd4TuourCKi2owFHxl4o1eXU-rnsyA3iS28bo_iRMofq9ZpgaC4nqwVegbFPHclST1J9xTIQ8iZq-SsTqQRd6Ro2cwfrp56mTOA9Z7gjrQJErCpNgi3S7PFxiB6GszPPS5U32_EMd6jJIzyO73fqUt7iUZNSvcojTdx7r9EZiT7lwtSjiBsY_kLzlOHFe27OulxHxSH2dzAiqV7iA";
    public static void getcallbackIp(){
        JSONObject result=HttpUtils.httpsRequest(String.format(callbackip_url,Access_token),"GET",null);
        log.info(result.toString());
        result.getJSONArray("ip_list");
    }


    public static void main(String[] args) {
        getcallbackIp();
    }
}
