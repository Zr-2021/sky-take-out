package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

/**
 * @author zijian-z
 * @date 2023/8/30
 */

public interface DishService {
    /**
     * add dish and flavor
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);

    /**
     * fetch by page
     * @param dishPageQueryDTO
     * @return
     */
    PageResult page(DishPageQueryDTO dishPageQueryDTO);

    /**
     * delete dishes
     * @param ids
     * @return
     */
    void deleteBatch(List<Long> ids);

    /**
     * get dish by id
     * @param id
     * @return
     */
    DishVO getDishWithFlavorById(Long id);

    /**
     * update dish
     * @param dishDTO
     * @return
     */
    void updateWithFlavor(DishDTO dishDTO);
}