package com.agony.controller;

import com.agony.resp.ResultData;
import com.agony.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Agony
 * @create 2024/3/28 21:53
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     */

    @PostMapping(value = "/seata/storage/decrease")
    ResultData<String> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {

        storageService.decrease(productId, count);
        return ResultData.success("扣减库存成功!");
    }
}
