package com.chenkang.decheng.Controller2;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chenkang.decheng.common.json.Body;
import com.chenkang.decheng.model.User;
import com.chenkang.decheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenkang
 * @since 2018-12-23
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("getUserInfo")
    public Body getUserInfo(){
        return Body.newInstance(userService.selectList(new EntityWrapper<User>()));
    }






}

