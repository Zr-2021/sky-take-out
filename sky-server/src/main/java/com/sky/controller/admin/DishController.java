package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zr
 * @date 2023/8/30
 */
@RestController
@RequestMapping("/admin/dish")
@Api(tags = "dish接口")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;

    /**
     * add dish
     *
     * @param dishDTO
     * @return
     */
    @PostMapping()
    @ApiOperation(value = "add dish")
    public Result<Object> save(@RequestBody DishDTO dishDTO) {
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    /**
     * fetch by page
     *
     * @param dishPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation(value = "fetch by page")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
        PageResult pageResult = dishService.page(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * delete dishes
     * @param ids
     * @return
     */
    @DeleteMapping()
    @ApiOperation(value = "delete dishes")
    public Result<Object> delete(@RequestParam List<Long> ids) {
        log.info("delete dish" + ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * get dish by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "get dish by id")
    public Result<DishVO> getById(@PathVariable Long id){
        log.info("get dish by id");
        DishVO dishVO = dishService.getDishWithFlavorById(id);
        return Result.success(dishVO);
    }

    /**
     * update dish
     * @param dishDTO
     * @return
     */
    @PutMapping()
    @ApiOperation(value = "update dish")
    public Result<Object> update(@RequestBody DishDTO dishDTO) {
        log.info("update dish");
        dishService.updateWithFlavor(dishDTO);
        return Result.success();
    }

    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品")
    public Result<List<Dish>> list(Long categoryId){
        List<Dish> list = dishService.list(categoryId);
        return Result.success(list);
    }
}
