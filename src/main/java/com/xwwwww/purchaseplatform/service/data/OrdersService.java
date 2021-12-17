package com.xwwwww.purchaseplatform.service.data;

import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface OrdersService {
    public Result getOrdersByShop(int shopId) throws Exception;

    public Result getOrderStatusNumber(int customerId) throws Exception;
}
