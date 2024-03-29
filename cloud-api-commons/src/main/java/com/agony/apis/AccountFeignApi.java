package com.agony.apis;

import com.agony.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Agony
 * @create 2024/3/28 21:18
 */
@FeignClient(name = "seata-account-service")
public interface AccountFeignApi {


    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  扣除金额
     * @return 结果
     */
    @PostMapping("/seata/account/decrease")
    ResultData<String> decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
