package com.agony.mapper;

import com.agony.entities.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author agony
 * @description 针对表【t_account】的数据库操作Mapper
 * @createDate 2024-03-28 21:58:42
 * @Entity com.agony.entities.Account
 */
public interface AccountMapper extends BaseMapper<Account> {


    /**
     * 扣减余额
     *
     * @param userId 用户id
     * @param money  本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);

}




