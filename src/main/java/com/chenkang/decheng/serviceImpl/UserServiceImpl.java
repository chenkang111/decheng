package com.chenkang.decheng.serviceImpl;

import com.chenkang.decheng.model.User;
import com.chenkang.decheng.mapper.UserMapper;
import com.chenkang.decheng.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenkang
 * @since 2018-12-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
