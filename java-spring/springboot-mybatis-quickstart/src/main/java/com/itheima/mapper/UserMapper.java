package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // 在运行时, 会自动生成该接口的实现类对象(代理对象), 并且将该对象交给IOC容器管理
public interface UserMapper {
    // 查询用户全部信息
    @Select("select * from tb_user")
    public List<User> list();
}
