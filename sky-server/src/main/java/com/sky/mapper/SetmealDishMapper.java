package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zijian-z
 * @date 2023/8/30
 */

@Mapper
public interface SetmealDishMapper {

    public List<Long> getSetmealIdsByDishIds(List<Long> ids);
}
