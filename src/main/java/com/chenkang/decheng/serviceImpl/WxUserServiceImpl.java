package com.chenkang.decheng.serviceImpl;


import javax.annotation.Resource;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chenkang.decheng.mapper.UserMapper;
import com.chenkang.decheng.mapper.WxuserDao;
import com.chenkang.decheng.model.Wxuser;
import com.chenkang.decheng.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("wxUserService")
public class WxUserServiceImpl  extends ServiceImpl<WxuserDao, Wxuser> implements  WxUserService {

}
