package com.chenkang.decheng.controller;


import com.chenkang.decheng.util.qydemo.GetWxinfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin
@RequestMapping("user")
@Slf4j
public class CommonController {

    @GetMapping("test")
    public  String test(){
        return "张三1";
    }


    @GetMapping("go")
    public ModelAndView geotemplete(ModelAndView mv, HttpServletRequest request){
        log.info("进去了————————————————————");
        mv.setViewName("login");
        Object code = request.getSession().getAttribute("code");
        if(code!=null && GetWxinfo.getWxinfo(code+"")!=null){
            request.getSession().invalidate();
            return mv;
        }else{
            System.out.println("白搭你跳转得没用");
            return null;
        }
    }
}
