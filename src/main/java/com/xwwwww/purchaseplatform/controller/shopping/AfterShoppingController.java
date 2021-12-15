package com.xwwwww.purchaseplatform.controller.shopping;

import com.xwwwww.purchaseplatform.entity.shopping.order.Orders;
import com.xwwwww.purchaseplatform.service.shopping.AfterShoppingService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class AfterShoppingController {
    @Autowired
    AfterShoppingService afterShoppingService;

    @ResponseBody
    @GetMapping("/afterShopping/apply")
    public Result ApplyForReturn(Orders order) throws Exception{
        return afterShoppingService.ApplyForReturn(order);
    }

    @ResponseBody
    @GetMapping("/afterShopping/process")
    public Result ProcessReturn (Orders order) throws Exception{
        return afterShoppingService.ProcessReturn(order);
    }

    @ResponseBody
    @GetMapping("/afterShopping/reject")
    public Result RejectReturn(Orders order) throws Exception{
        return afterShoppingService.RejectReturn(order);
    }
}
