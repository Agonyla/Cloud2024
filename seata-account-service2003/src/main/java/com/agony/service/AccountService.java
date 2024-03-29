package com.agony.service;

import com.agony.entities.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author agony
 * @description 针对表【t_account】的数据库操作Service
 * @createDate 2024-03-28 21:58:42
 */
public interface AccountService extends IService<Account> {


    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  本次消费金额
     */
    void decrease(Long userId, Long money);
}
