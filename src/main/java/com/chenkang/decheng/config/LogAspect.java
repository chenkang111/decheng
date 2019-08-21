package com.chenkang.decheng.config;


import com.chenkang.decheng.annotate.Log;
import com.chenkang.decheng.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.chenkang.decheng.annotate.Log)")
    public void logPointCut() {
        //代表着从给@Log注解的地方为切面
    }


    @Before("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        //进入请求前
        //获取request
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        //获取用户信息
        User user =(User)request.getSession().getAttribute("user");

        //请求地址
        System.out.println(request.getRequestURI());
        //注解给的参数
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println(signature.getMethod().getAnnotation(Log.class).method());
        //获取参数
        Object[] args = joinPoint.getArgs();//方法的参数
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i].getClass().getName());
        }
        //存储数据库
    }
}
