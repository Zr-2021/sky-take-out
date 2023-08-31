package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author zr
 * @date 2023/8/31
 */

@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺接口")
@Slf4j
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置店铺营业状态
     *
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation(value = "设置店铺营业状态")
    public Result<Object> setStatus(@PathVariable Integer status) {
        log.info("设置店铺营业状态:{}", status == 1 ? "营业" : "打烊");
        redisTemplate.opsForValue().set("SHOP_STATUS", status);
        return Result.success();
    }

    /**
     * 获取营业状态
     * @return
     */
    @GetMapping("/status")
    @ApiOperation(value = "获取营业状态")
    public Result<Integer> getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get("SHOP_STATUS");
        log.info("店铺营业状态:{}", status == 1 ? "营业" : "打烊");
        return Result.success(status);
    }
}
