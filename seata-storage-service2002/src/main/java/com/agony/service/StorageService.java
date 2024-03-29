package com.agony.service;

import com.agony.entities.Storage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author agony
 * @description 针对表【t_storage】的数据库操作Service
 * @createDate 2024-03-28 21:46:56
 */
public interface StorageService extends IService<Storage> {
    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     产品数量
     */
    void decrease(Long productId, Integer count);
}
