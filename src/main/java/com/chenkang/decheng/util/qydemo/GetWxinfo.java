package com.chenkang.decheng.util.qydemo;

import com.alibaba.fastjson.JSONObject;
import com.chenkang.decheng.common.utils.HttpUtils;

public class GetWxinfo {



    public static String getuserinfo="https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";

    public static String  getWxinfo (String code){
        JSONObject json = new JSONObject();
        json.put("access_token","-mOUddbPcRLRSwzRUROnAcVoSTlPdGfs7PWkPJzXeA3ce20zIOlX-jnxIaUnNKwNT_BQSlgqUhjQRm5lPYCMavikqUv9md3IeNi-QLBM7FzaUT-gGKVX58up6eyZJBDxYwj95tMqlzUNRoPDZ-jfX-dq7lzwSN6pZBBF0zE-LIVZ-aBzwvJ1LCWTUvZeAw3Rs8Dy1ZVxtJ_Ly_bFsC7LzA");
        json.put("code",code);
        JSONObject result= HttpUtils.httpsRequest(getuserinfo,"GET",json.toString());
        return result.toString();
    }


}
