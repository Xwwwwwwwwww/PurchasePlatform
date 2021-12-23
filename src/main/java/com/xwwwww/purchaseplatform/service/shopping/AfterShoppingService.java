package com.xwwwww.purchaseplatform.service.shopping;

import com.xwwwww.purchaseplatform.entity.shopping.order.Orders;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface AfterShoppingService {
    //顾客申请退款
    Result ApplyForReturn(int id);

    //店铺管理员同意退货
    Result ProcessReturn(Orders order);

    //店铺管理员拒绝退货
    Result RejectReturn(Orders order);

    //查询某人的总花销
    Result getTotalAmount(int customerId);
}
