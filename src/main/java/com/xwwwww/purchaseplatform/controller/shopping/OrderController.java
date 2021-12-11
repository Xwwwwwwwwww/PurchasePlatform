package com.xwwwww.purchaseplatform.controller.shopping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCart;
import com.xwwwww.purchaseplatform.entity.shopping.order.Order;
import com.xwwwww.purchaseplatform.mapper.shopping.order.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class OrderController {
    @Autowired
    OrderMapper orderMapper;

    @ResponseBody
    @GetMapping("/order")
    public List<Order> getOrderByCustomerId(int customer_id) throws Exception {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
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
    public List<Order> getOrderByStatus(int order_status) throws Exception{
        QueryWrapper<Order> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("order_status",order_status);
        return orderMapper.selectList(queryWrapper);
    }

    @ResponseBody
    @PostMapping("/order")
    public int insertShoppingCart(Order order) throws Exception{
        return orderMapper.insert(order);
    }

    @ResponseBody
    @DeleteMapping("/order")
    public int deleteShoppingCart(int id) throws Exception{
        return orderMapper.deleteById((id));
    }

    @ResponseBody
    @PutMapping("/order")
    public int updateShoppingCart(Order order) throws  Exception{
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
    public List<Order> getAllOrder() throws Exception{
        return orderMapper.selectList(null);
    }

}
