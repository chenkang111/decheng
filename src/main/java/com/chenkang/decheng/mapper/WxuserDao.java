package com.chenkang.decheng.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chenkang.decheng.model.Wxuser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository("wxuserDao")
public interface WxuserDao  extends BaseMapper<Wxuser> {
}