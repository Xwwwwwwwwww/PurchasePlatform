package com.xwwwww.purchaseplatform.service.shopping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.entity.shopping.order.Orders;
import com.xwwwww.purchaseplatform.mapper.shopping.commodity.CommodityMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.order.OrderMapper;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//待付款0 已付款1 已发货2 申请退款3 已退款4 拒绝退款5 待评价6
@Service
public class AfterShoppingServiceImpl implements AfterShoppingService{
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    CommodityMapper commodityMapper;

    /**
     *
     * @param order
     * @return boolean
     * 顾客申请退款
     */
    @Override
    public Result ApplyForReturn(Orders order) {
        if (order.getOrderStatus()!=2)
            return Result.FAIL("不是已发货状态");
        order.setOrderStatus(3);
        orderMapper.updateById(order);
        return Result.SUCCESS(order);
    }

    /**
     *
     * @param order
     * @return boolean
     * 处理退货申请(同意)
     */
    @Override
    public Result ProcessReturn(Orders order) {
        //该订单不是申请退款的订单
        if (order.getOrderStatus()!=3)
            return Result.FAIL("不是申请退款状态");
        //同意退款
        order.setOrderStatus(4);
        orderMapper.updateById(order);
        //获取被退货的商品
        Commodity commodity=commodityMapper.selectById(order.getCommodityId());
        //库存增加
        commodity.setStock(commodity.getStock()+order.getQuantity());
        commodityMapper.updateById(commodity);
        return Result.SUCCESS(order);
    }

    /**
     *
     * @param order
     * @return
     * 拒绝退款
     */
    @Override
    public Result RejectReturn(Orders order) {
        if (order.getOrderStatus()!=3)
            return Result.FAIL("不是申请退款的状态");
        order.setOrderStatus(5);
        orderMapper.updateById(order);
        return Result.SUCCESS(order);
    }

    /**
     *
     * @param customerId
     * @return double
     * 除了申请退款状态，所有订单都要统计
     */
    @Override
    public Result getTotalAmount(int customerId) {
        double amount=0;
        QueryWrapper<Orders> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("customer_id",customerId);
        List<Orders> ordersList=orderMapper.selectList(queryWrapper);
        for (Orders order : ordersList) {
            if (order.getOrderStatus()!=3){
                amount+=order.getPayPrice();
            }
        }
        return Result.SUCCESS(amount);
    }
}
