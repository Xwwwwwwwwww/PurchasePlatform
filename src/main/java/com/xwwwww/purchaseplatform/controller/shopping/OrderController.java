package com.xwwwww.purchaseplatform.controller.shopping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.order.Orders;
import com.xwwwww.purchaseplatform.mapper.shopping.commodity.CommodityMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.order.OrderMapper;
import com.xwwwww.purchaseplatform.service.data.OrdersService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shopping")
public class OrderController {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    CommodityMapper commodityMapper;

    @Autowired
    OrdersService ordersService;

    @ResponseBody
    @GetMapping("/order")
    public List<Orders> getOrderByCustomerId(int customer_id) throws Exception {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id", customer_id);
        return orderMapper.selectList(queryWrapper);
    }

    /**
     *
     * @param order_status
     * @return list
     * @throws Exception
     * 根据订单状态获取订单
     */
    @ResponseBody
    @GetMapping("/order/status")
    public List<Orders> getOrderByStatus(int order_status) throws Exception{
        QueryWrapper<Orders> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("order_status",order_status);
        return orderMapper.selectList(queryWrapper);
    }

    @ResponseBody
    @PostMapping("/order")
    public int insertShoppingCart(Orders order) throws Exception{
        return orderMapper.insert(order);
    }

    @ResponseBody
    @DeleteMapping("/order")
    public int deleteShoppingCart(int id) throws Exception{
        return orderMapper.deleteById((id));
    }

    @ResponseBody
    @PutMapping("/order")
    public int updateShoppingCart(Orders order) throws  Exception{
        return orderMapper.updateById(order);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有订单
     */
    @ResponseBody
    @GetMapping("/order/all")
    public List<Orders> getAllOrder() throws Exception{
        return orderMapper.selectList(null);
    }

    /**
     *
     * @param shopId
     * @return
     * @throws Exception
     * 查询某家店铺的所有订单
     */
    @ResponseBody
    @GetMapping("/order/shop")
    public Result getOrderByShop(int shopId) throws Exception {
        return ordersService.getOrdersByShop(shopId);
    }
}
