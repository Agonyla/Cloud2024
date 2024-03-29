package com.agony.service.impl;

import com.agony.entities.Storage;
import com.agony.mapper.StorageMapper;
import com.agony.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author agony
 * @description 针对表【t_storage】的数据库操作Service实现
 * @createDate 2024-03-28 21:46:56
 */
@Service
@Slf4j
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage>
        implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     产品数量
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");
    }
}




