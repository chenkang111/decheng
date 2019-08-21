package com.chenkang.decheng.annotate;



import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {


    String method()  default "";//代表注解里的参数信息定义两个就是两个参数
}
