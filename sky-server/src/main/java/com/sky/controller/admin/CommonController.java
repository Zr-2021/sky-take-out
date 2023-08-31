package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author zr
 * @date 2023/8/30
 */
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {

    /**
     * upload file
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation(value = "upload file")
    public Result<String> upload(MultipartFile file) {
        String filename = file.getOriginalFilename();
        log.info("upload file" + filename);
        try {
            file.transferTo(new File("/Users/543lab/zr2022/sky-take-out/sky-server/src/main/resources/static/images/" + filename));
            return Result.success("http://localhost:8080/static/images/" + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
