package com.agony.service.impl;

import com.agony.entities.Account;
import com.agony.mapper.AccountMapper;
import com.agony.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author agony
 * @description 针对表【t_account】的数据库操作Service实现
 * @createDate 2024-03-28 21:58:42
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
        implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    /**
     * 扣减金额
     *
     * @param userId 用户id
     * @param money  本次消费金额
     */
    @Override
    public void decrease(Long userId, Long money) {
        log.info("------->account-service中扣减账户余额开始");
        accountMapper.decrease(userId, money);
        myTimeOut();
        // int age = 10/0;
        log.info("------->account-service中扣减账户余额结束");
    }

    /**
     * 模拟超时异常，全局事务回滚
     */
    private static void myTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(65);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




