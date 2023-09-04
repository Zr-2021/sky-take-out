package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @author zr
 * @date 2023/8/31
 */
@Mapper
public interface UserMapper {

    /**
     * 根据openid查询用户
     * @param openid
     * @return
     */
    @Select("select * from user where openid=#{openid}")
    User getByOpenId(String openid);

    /**
     * 注册新用户
     * @param user
     */
    void insert(User user);

    @Select("select * from user where id=#{id}")
    User getById(Long userId);

    Integer countByMap(Map map);
}
