package com.agony.apis;

import com.agony.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Agony
 * @create 2024/3/28 21:18
 */
@FeignClient(name = "seata-storage-service")
public interface StorageFeignApi {
    /**
     * 扣减库存
     *
     * @param productId 商品id
     * @param count     扣除数量
     * @return 结果
     */
    @PostMapping(value = "/seata/storage/decrease")
    ResultData<String> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
