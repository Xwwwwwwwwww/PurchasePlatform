package com.xwwwww.purchaseplatform.service.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.order.Orders;
import com.xwwwww.purchaseplatform.mapper.constant.order.OrderStatusMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.commodity.CommodityMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.order.OrderMapper;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    CommodityMapper commodityMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Result getOrdersByShop(int shopId) throws Exception {
        List<Orders> total=new ArrayList<>();//总列表
        QueryWrapper<Commodity> commodityQueryWrapper=new QueryWrapper<>();
        commodityQueryWrapper.eq("belonging_Shop",shopId);
        List<Commodity> commodityList=commodityMapper.selectList(commodityQueryWrapper);
        for (Commodity commodity : commodityList) {
            QueryWrapper<Orders> ordersQueryWrapper=new QueryWrapper<>();
            ordersQueryWrapper.eq("commodity_Id",commodity.getId());
            List<Orders> ordersList=orderMapper.selectList(ordersQueryWrapper);
            total.addAll(ordersList);
        }
        return Result.SUCCESS(total);
    }
}
