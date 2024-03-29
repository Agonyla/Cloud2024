package com.agony.service.impl;

import com.agony.apis.AccountFeignApi;
import com.agony.apis.StorageFeignApi;
import com.agony.entities.Order;
import com.agony.mapper.OrderMapper;
import com.agony.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author agony
 * @description 针对表【t_order】的数据库操作Service实现
 * @createDate 2024-03-28 21:13:29
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AccountFeignApi accountFeignApi;

    @Resource
    private StorageFeignApi storageFeignApi;

    @Override
    @GlobalTransactional(name = "agony-create-order", rollbackFor = Exception.class)
    public void create(Order order) {

        // xid 检查
        String xid = RootContext.getXID();

        log.info("==================>开始新建订单" + "\t" + "xid_order:" + xid);
        order.setStatus(0);
        int insertResult = orderMapper.insert(order);

        Order orderFromDB = null;

        if (insertResult > 0) {
            orderFromDB = orderMapper.selectById(order.getId());
            log.info("-------> 新建订单成功，orderFromDB info: " + orderFromDB);
            System.out.println();

            //2. 扣减库存
            log.info("-------> 订单微服务开始调用Storage库存，做扣减count");
            storageFeignApi.decrease(order.getProductId(), orderFromDB.getCount());
            log.info("-------> 订单微服务结束调用Storage库存，做扣减完成");
            System.out.println();

            //3. 扣减账号余额
            log.info("-------> 订单微服务开始调用Account账号，做扣减money");
            accountFeignApi.decrease(order.getUserId(), orderFromDB.getMoney());
            log.info("-------> 订单微服务结束调用Account账号，做扣减完成");
            System.out.println();

            //4. 修改订单状态
            //订单状态status：0：创建中；1：已完结
            orderFromDB.setStatus(1);
            QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
            orderQueryWrapper.eq("user_id", orderFromDB.getUserId());
            orderQueryWrapper.eq("status", 0);
            int updateResult = orderMapper.update(orderFromDB, orderQueryWrapper);
            log.info("-------> 修改订单状态完成" + "\t" + updateResult);
            log.info("-------> orderFromDB info: " + orderFromDB);
        }
        System.out.println();
        log.info("==================>结束新建订单" + "\t" + "xid_order:" + xid);
    }


}




