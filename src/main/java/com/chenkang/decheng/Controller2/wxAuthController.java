package com.chenkang.decheng.Controller2;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("wxauth")
@Controller
@Slf4j
public class wxAuthController {

    @RequestMapping("auth")
    public String wxAuth(HttpServletRequest request){
        System.out.println("进入跳转得回调");
        String code=request.getParameter("code");
        request.getSession().setAttribute("code",code);//来隐藏参数
        log.info(code);
        return "redirect:http://chenkang.natapp1.cc/decheng/user/go";
    }
}
