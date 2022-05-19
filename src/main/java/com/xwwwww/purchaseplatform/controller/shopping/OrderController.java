package com.xwwwww.purchaseplatform.controller.shopping;

import com.xwwwww.purchaseplatform.entity.shopping.order.Orders;
import com.xwwwww.purchaseplatform.service.data.OrdersService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="订单模块")
@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class OrderController {
    @Autowired
    OrdersService ordersService;

    @ApiOperation(value="根据用户id获取订单")
    @ResponseBody
    @GetMapping("/order")
    public Result getOrderByCustomerId(int customerId) throws Exception {
        return ordersService.getOrderByCustomerId(customerId);
    }

    /**
     *
     * @param orderStatus
     * @return list
     * @throws Exception
     * 根据订单状态获取订单
     */
    @ApiOperation(value="根据订单状态获取订单")
    @ResponseBody
    @GetMapping("/order/status")
    public Result getOrderByStatus(int orderStatus) throws Exception{
        return ordersService.getOrderByStatus(orderStatus);
    }

    @ApiOperation(value="添加数据")
    @ResponseBody
    @PostMapping("/order")
    public Result insertOrder(@RequestBody Orders order) throws Exception{
        return ordersService.insertOrder(order);
    }

    @ApiOperation(value="删除数据")
    @ResponseBody
    @DeleteMapping("/order")
    public Result deleteOrder(int id) throws Exception{
        return ordersService.deleteOrder(id);
    }

    @ApiOperation(value="修改数据")
    @ResponseBody
    @PutMapping("/order")
    public Result updateOrder(@RequestBody Orders order) throws  Exception{
        return ordersService.updateOrder(order);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有订单
     */
    @ApiOperation(value="查询所有订单")
    @ResponseBody
    @GetMapping("/order/all")
    public Result getAllOrder() throws Exception{
        return ordersService.getAllOrder();
    }

    /**
     *
     * @param shopId
     * @return
     * @throws Exception
     * 查询某家店铺的所有订单
     */
    @ApiOperation(value="查询某家店铺的所有订单")
    @ResponseBody
    @GetMapping("/order/shop")
    public Result getOrderByShop(int shopId) throws Exception {
        return ordersService.getOrdersByShop(shopId);
    }

    /**
     *
     * @param customerId
     * @return
     * @throws Exception
     * 查询某顾客的4种订单状态
     */
    @ApiOperation(value="查询某顾客的4种订单状态")
    @ResponseBody
    @GetMapping("/order/orderStatusNumber")
    public Result getOrderStatusNumber(int customerId) throws Exception{
        return ordersService.getOrderStatusNumber(customerId);
    }

    @ApiOperation(value="根据商品id获取订单")
    @ResponseBody
    @GetMapping("/order/commodity")
    public Result getOrderByCommodity(int commodityId) throws Exception{
        return ordersService.getOrderByCommodityId(commodityId);
    }

    @ApiOperation(value="根据用户和订单状态获取订单")
    @ResponseBody
    @GetMapping("/order/status/customer")
    public Result grtOrderByStatusAndCustomer(Orders order)throws Exception{
        return ordersService.getOrderByStatus(order);
    }
}
