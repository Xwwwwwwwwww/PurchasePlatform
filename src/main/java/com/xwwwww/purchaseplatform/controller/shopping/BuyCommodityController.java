package com.xwwwww.purchaseplatform.controller.shopping;

import com.xwwwww.purchaseplatform.entity.shopping.order.Orders;
import com.xwwwww.purchaseplatform.service.shopping.BuyCommodityService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="购物模块")
@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class BuyCommodityController {
    @Autowired
    BuyCommodityService buyCommodityService;

    @ApiOperation(value="从商品详情下单")
    @ResponseBody
    @PostMapping("/buy/directly")
    public Result BuyDirectly(@RequestBody Orders order) throws Exception{
        return buyCommodityService.BuyDirectly(order);
    }

    @ApiOperation(value="从购物车下单")
    @ResponseBody
    @PostMapping("/buy/shoppingCart")
    public Result BuyInShoppingCart(@RequestBody Orders order) throws Exception{
        return buyCommodityService.BuyInShoppingCart(order);
    }

    @ApiOperation(value="小程序没用过，不知道干啥的")
    @ResponseBody
    @PostMapping("/buy/processOrder")
    public Result ProcessOrder(int orderId) throws Exception{
        return buyCommodityService.ProcessOrder(orderId);
    }

    @ApiOperation(value="付款")
    @ResponseBody
    @PostMapping("/buy/pay")
    public Result pay(int orderId) throws Exception{
        return buyCommodityService.Pay(orderId);
    }

    @ApiOperation(value="确认收货")
    @ResponseBody
    @PostMapping("/buy/receive")
    public Result receive(int orderId) throws Exception{
        return buyCommodityService.ReceiveOrder(orderId);
    }
}
