package com.xwwwww.purchaseplatform.service.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.constant.order.OrderStatusNumber;
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

    /**
     *
     * @param customerId
     * @return
     * @throws Exception
     * 查询某顾客的4种订单状态
     */
    @Override
    public Result getOrderStatusNumber(int customerId) throws Exception {
        QueryWrapper<Orders> ordersQueryWrapper=new QueryWrapper<>();
        ordersQueryWrapper.eq("customer_Id",customerId);
        List<Orders> ordersList=orderMapper.selectList(ordersQueryWrapper);

        OrderStatusNumber orderStatusNumber=new OrderStatusNumber();
        int toBePaid = 0;
        int toBeSent = 0;
        int toBeReceived = 0;
        int toBeEvaluated = 0;
        for (Orders order : ordersList) {
            if (order.getOrderStatus()==0)
                toBePaid++;
            else if (order.getOrderStatus()==1)
                toBeSent++;
            else if (order.getOrderStatus()==2)
                toBeReceived++;
            else if (order.getOrderStatus()==6)
                toBeEvaluated++;
            else
                continue;
        }
        orderStatusNumber.setToBePaid(toBePaid);
        orderStatusNumber.setToBeSent(toBeSent);
        orderStatusNumber.setToBeReceived(toBeReceived);
        orderStatusNumber.setToBeEvaluated(toBeEvaluated);
        System.out.println(orderStatusNumber);
        return Result.SUCCESS(orderStatusNumber);
    }

    @Override
    public Result getOrderByCommodityId(int commodityId) throws Exception {
        QueryWrapper<Orders> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("commodity_Id",commodityId);
        return Result.SUCCESS(orderMapper.selectList(queryWrapper));
    }

    @Override
    public Result getOrderByCustomerId(int customerId) throws Exception {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id", customerId);
        return Result.SUCCESS(orderMapper.selectList(queryWrapper));
    }

    @Override
    public Result getOrderByStatus(int orderStatus) throws Exception {
        QueryWrapper<Orders> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("order_status",orderStatus);
        return Result.SUCCESS(orderMapper.selectList(queryWrapper));
    }

    @Override
    public Result insertOrder(Orders order) throws Exception {
        orderMapper.insert(order);
        return Result.SUCCESS(order.getId());
    }

    @Override
    public Result deleteOrder(int id) throws Exception {
        orderMapper.deleteById(id);
        return Result.SUCCESS();
    }

    @Override
    public Result updateOrder(Orders order) throws Exception {
        orderMapper.updateById(order);
        return Result.SUCCESS();
    }

    @Override
    public Result getAllOrder() throws Exception {
        return Result.SUCCESS(orderMapper.selectList(null));
    }
}
