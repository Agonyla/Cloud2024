package com.agony.mapper;

import com.agony.entities.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author agony
 * @description 针对表【t_storage】的数据库操作Mapper
 * @createDate 2024-03-28 21:46:56
 * @Entity com.agony.entities.Storage
 */
public interface StorageMapper extends BaseMapper<Storage> {
    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     产品数量
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}




