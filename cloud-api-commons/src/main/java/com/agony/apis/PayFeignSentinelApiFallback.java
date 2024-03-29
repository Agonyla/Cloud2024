package com.agony.apis;

import com.agony.resp.ResultData;
import com.agony.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @author Agony
 * @create 2024/3/27 16:19
 */
@Component
public class PayFeignSentinelApiFallback implements PayFeignSentinelApi {
    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}
