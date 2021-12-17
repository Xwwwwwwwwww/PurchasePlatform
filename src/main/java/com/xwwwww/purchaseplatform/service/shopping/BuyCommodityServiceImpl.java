package com.xwwwww.purchaseplatform.service.shopping;

import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.order.Orders;
import com.xwwwww.purchaseplatform.mapper.shopping.commodity.CommodityMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.ShoppingCartMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.order.OrderMapper;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyCommodityServiceImpl implements BuyCommodityService{
    @Autowired
    CommodityMapper commodityMapper;

    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Result BuyInShoppingCart(Orders order) throws Exception {
        //commodityId是Commodity的主键
        Commodity commodity=commodityMapper.selectById(order.getCommodityId());
        System.out.println("打印商品编号："+order.getCommodityId());
        System.out.println("打印商品"+commodity);
        System.out.println("打印传入的数据"+order);
        int stock=commodity.getStock();
        if (stock<order.getQuantity())
            return Result.FAIL("库存不足");
        else
        {
            shoppingCartMapper.deleteOneItem(order.getCustomerId(),order.getCommodityId());//删除购物车里对应的记录
            orderMapper.insert(order);//添加订单
            System.out.println("打印创建的订单"+order);
            return Result.SUCCESS(order.getId());//会自动返回id
        }
    }

    @Override
    public Result BuyDirectly(Orders order) throws Exception {
        //commodityId是Commodity的主键
        Commodity commodity=commodityMapper.selectById(order.getCommodityId());
        System.out.println("打印商品"+commodity);
        int stock=commodity.getStock();
        System.out.println("打印订单状态："+order.getOrderStatus());
        if (stock<order.getQuantity())
            return Result.FAIL("库存不足");
        else
        {
            orderMapper.insert(order);//添加订单
            return Result.SUCCESS(order.getId());
        }
    }

    /**
     *
     * @param orderId
     * @return boolean
     * @throws Exception
     * 处理已付款的订单，发货
     */
    @Override
    public Result ProcessOrder(int orderId) throws Exception {
        Orders order=orderMapper.selectById(orderId);
        if (order.getOrderStatus()!=1)
            return Result.FAIL("不是已付款的订单");
        order.setOrderStatus(2);
        orderMapper.updateById(order);//已发货
        return Result.SUCCESS(order);
    }

    //待付款0 已付款1 已发货2 申请退款3 已退款4

    /**
     *
     * @param orderId
     * @return boolean
     * @throws Exception
     * 支付待付款的订单
     */
    @Override
    public Result Pay(int orderId) throws Exception {
        Orders order=orderMapper.selectById(orderId);
        Commodity commodity=commodityMapper.selectById(order.getCommodityId());
        int stock=commodity.getStock();
        if (order.getOrderStatus()!=0)
            return Result.FAIL("不是待支付状态");
        if (stock<order.getQuantity())
            return Result.FAIL("库存不足");
        stock-=order.getQuantity();
        commodity.setStock(stock);
        commodityMapper.updateById(commodity);//更新商品的库存
        order.setOrderStatus(1);
        orderMapper.updateById(order);//已付款
        return Result.SUCCESS(order);
    }

    /**
     *
     * @param orderId
     * @return
     * @throws Exception
     * 顾客确认收货，订单状态变为待评价
     */
    @Override
    public Result ReceiveOrder(int orderId) throws Exception {
        Orders order=orderMapper.selectById(orderId);
        if (order.getOrderStatus()!=2)
            return Result.FAIL("不是待收货状态");
        order.setOrderStatus(6);
        return Result.SUCCESS(order);
    }
}