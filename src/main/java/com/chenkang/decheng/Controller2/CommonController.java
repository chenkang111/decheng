package com.chenkang.decheng.Controller2;


import com.chenkang.decheng.annotate.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin
@RequestMapping("user")
@Slf4j
public class CommonController {

    @GetMapping("test")
    public  String test(){
        return "张三1";
    }


    @RequestMapping("redirect")
    public String redirect(ModelAndView mv, String code, HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("test", "test");// 创建一个cookie，cookie的名字是key
        cookie.setDomain("localhost");
        cookie.setPath("/");
        // 设置Cookie的有效期
        // cookie.setHttpOnly(true);
        // 将cookie对象添加到response对象中，这样服务器在输出response对象中的内容时就会把cookie也输出到客户端浏览器
        response.addCookie(cookie);
        return "redirect:http://localhost:8080/demo/ceshi.html";
    }



    @Log(method = "首页")
    @GetMapping("go")
    public ModelAndView geotemplete(ModelAndView mv, HttpServletRequest request){
        log.info("进去了————————————————————");
        mv.setViewName("login");
        request.getSession().setAttribute("code","value");
        Object code = request.getSession().getAttribute("code");
/*        if(code!=null && GetWxinfo.getWxinfo(code+"")!=null){
            request.getSession().invalidate();
            return mv;
        }else{
            System.out.println("白搭你跳转得没用");
            return null;
        }*/
        return mv;
    }
}
