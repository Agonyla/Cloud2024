package com.agony.service.impl;

import com.agony.entities.Pay;
import com.agony.mapper.PayMapper;
import com.agony.service.PayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author agony
 * @description 针对表【t_pay(支付交易表)】的数据库操作Service实现
 * @createDate 2024-03-14 21:43:00
 */
@Service
public class PayServiceImpl extends ServiceImpl<PayMapper, Pay>
        implements PayService {

    @Resource
    private PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        return payMapper.insert(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteById(id);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateById(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectById(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectList(null);
    }
}




