package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.DishFlavor;
import com.sky.entity.Employee;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zijian-z
 * @date 2023/8/30
 */

@Mapper
public interface DishFlavorMapper {
    void insertBatch(List<DishFlavor> flavors);

    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    @Delete("delete from dish_flavor where dish_id=#{dishId}")
    void deleteByDishId(Long dishId);

    @Select("select * from dish_flavor where dish_id=#{dishId}")
    List<DishFlavor> getByDishId(Long dishId);
}
