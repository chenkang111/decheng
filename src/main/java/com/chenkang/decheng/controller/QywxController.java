package com.chenkang.decheng.controller;

import com.chenkang.decheng.util.qywx.AesException;
import com.chenkang.decheng.util.qywx.WXBizMsgCrypt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static com.chenkang.decheng.util.qydemo.Constant.corid;

@Controller
@RequestMapping("qywx")
@Slf4j
public class QywxController {


    public static final String sToken="Jlyg4a17HONtLJnr";

    public static  final String sEncodingAESKey="aXMnVvBGLP6wgm1P3GwacNJheUSE2BZbeCWT7j6Q1Pu";

    //nXsEwNpX9u85bFINJkMT6nE7   token
    //zC9XoZYOgupWVHWXagM1MKtstDtmHcOLYskajYfpLdJ  EncodingAESKey
    @PostMapping("changeCall")
    public void  change_txlCall(HttpServletRequest request, HttpServletResponse response){
        //通讯录修改回调
        System.out.println("业务回调");
        try {
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, corid);
        } catch (AesException e) {
            //异常捕获
            e.printStackTrace();
        }
    }

    @RequestMapping("changeCall1")
    public void  change_txlCall1(HttpServletRequest request ,HttpServletResponse response){
        //通讯录修改回调
        String msg_signature= request.getParameter("msg_signature");
        String timestamp= request.getParameter("timestamp");
        String nonce= request.getParameter("nonce");
        try {
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, corid);
            if(request.getMethod().toUpperCase().equals("GET")){
                //get方式请求是验证用得
                String sVerifyEchoStr= request.getParameter("echostr");
                PrintWriter printWriter =response.getWriter();
                printWriter.write(wxcpt.VerifyURL(msg_signature,timestamp,nonce,sVerifyEchoStr));
                printWriter.flush();
                printWriter.close();
            }
            //post请求得揭秘就ok
            String msg= wxcpt.DecryptMsg(msg_signature,timestamp,nonce,getBody(request));
            log.info(msg);
        } catch (AesException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    public String getBody (HttpServletRequest request){
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            StringBuilder buffer = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
