package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zr
 * @date 2023/9/1
 */

@RestController
@RequestMapping("/user/shoppingCart")
@Slf4j
@Api(tags = "c端购物车相关接口")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加购物车
     *
     * @param shoppingCartDTO
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加购物车")
    public Result<Object> add(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("添加购物车:{}",shoppingCartDTO);
        shoppingCartService.add(shoppingCartDTO);
        return Result.success();
    }

    /**
     * 查看购物车
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "查看购物车")
    public Result<List<ShoppingCart>> list(){
        List<ShoppingCart> list = shoppingCartService.showShoppingCart();
        return Result.success(list);
    }

    /**
     * 清空购物车
     * @return
     */
    @DeleteMapping("/clean")
    @ApiOperation(value = "清空购物车")
    public Result<Object> clean(){
        shoppingCartService.cleanShoppingCart();
        return Result.success();
    }

    /**
     * 购物车数量减少按钮
     * @param shoppingCartDTO
     * @return
     */
    @PostMapping("/sub")
    @ApiOperation("购物车数量减少按钮")
    public Result<Object> sub(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("购物车数量减少按钮:{}",shoppingCartDTO);
        shoppingCartService.sub(shoppingCartDTO);
        return Result.success();
    }
}
