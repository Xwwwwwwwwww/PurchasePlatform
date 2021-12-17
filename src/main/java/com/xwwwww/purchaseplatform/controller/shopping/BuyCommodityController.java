package com.xwwwww.purchaseplatform.controller.shopping;

import com.xwwwww.purchaseplatform.entity.shopping.order.Orders;
import com.xwwwww.purchaseplatform.service.shopping.BuyCommodityService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class BuyCommodityController {
    @Autowired
    BuyCommodityService buyCommodityService;

    @ResponseBody
    @PostMapping("/buy/directly")
    public Result BuyDirectly(@RequestBody Orders order) throws Exception{
        return buyCommodityService.BuyDirectly(order);
    }

    @ResponseBody
    @PostMapping("/buy/shoppingCart")
    public Result BuyInShoppingCart(@RequestBody Orders order) throws Exception{
        return buyCommodityService.BuyInShoppingCart(order);
    }
    @ResponseBody
    @PostMapping("/buy/processOrder")
    public Result ProcessOrder(int orderId) throws Exception{
        return buyCommodityService.ProcessOrder(orderId);
    }

    @ResponseBody
    @PostMapping("/buy/pay")
    public Result pay(int orderId) throws Exception{
        return buyCommodityService.Pay(orderId);
    }

    @ResponseBody
    @PostMapping("/buy/receive")
    public Result receive(int orderId) throws Exception{
        return buyCommodityService.ReceiveOrder(orderId);
    }
}
