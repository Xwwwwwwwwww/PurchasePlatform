package com.xwwwww.purchaseplatform.service.shopping;

import com.xwwwww.purchaseplatform.entity.shopping.order.Orders;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface BuyCommodityService {
    Result BuyInShoppingCart(Orders order) throws Exception;

    Result BuyDirectly(Orders order) throws Exception;

    Result Pay(Orders order) throws Exception;

    Result ProcessOrder(Orders order) throws Exception;
}
