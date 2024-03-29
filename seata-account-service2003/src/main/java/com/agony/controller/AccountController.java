package com.agony.controller;

import com.agony.resp.ResultData;
import com.agony.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Agony
 * @create 2024/3/28 22:05
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;


    @PostMapping("/seata/account/decrease")
    ResultData<String> decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money) {
        accountService.decrease(userId, money);
        return ResultData.success("扣减账户余额成功！");
    }
}
