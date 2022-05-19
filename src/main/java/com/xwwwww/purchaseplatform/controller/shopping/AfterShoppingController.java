package com.xwwwww.purchaseplatform.controller.shopping;

import com.xwwwww.purchaseplatform.entity.shopping.order.Orders;
import com.xwwwww.purchaseplatform.service.shopping.AfterShoppingService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="售后模块")
@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class AfterShoppingController {
    @Autowired
    AfterShoppingService afterShoppingService;

    @ApiOperation(value="申请退款")
    @ResponseBody
    @GetMapping("/afterShopping/apply")
    public Result ApplyForReturn(int id) throws Exception{
        return afterShoppingService.ApplyForReturn(id);
    }

    @ApiOperation(value="同意退款")
    @ResponseBody
    @GetMapping("/afterShopping/process")
    public Result ProcessReturn (Orders order) throws Exception{
        return afterShoppingService.ProcessReturn(order);
    }

    @ApiOperation(value="拒绝退款")
    @ResponseBody
    @GetMapping("/afterShopping/reject")
    public Result RejectReturn(Orders order) throws Exception{
        return afterShoppingService.RejectReturn(order);
    }

    @ApiOperation(value="获取花费的总金额")
    @ResponseBody
    @GetMapping("/afterShopping/amount")
    public Result getTotalAmount(int customerId) throws Exception{
        return afterShoppingService.getTotalAmount(customerId);
    }
}
