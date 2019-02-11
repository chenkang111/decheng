package com.chenkang.decheng.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin
@RequestMapping("user")
@Slf4j
public class CommonController {

    @GetMapping("test")
    public  String test(){
        return "张三";
    }


    @GetMapping("go")
    public ModelAndView geotemplete(ModelAndView mv){
        log.info("进去了————————————————————");
        mv.setViewName("login");
        return mv;
    }
}
