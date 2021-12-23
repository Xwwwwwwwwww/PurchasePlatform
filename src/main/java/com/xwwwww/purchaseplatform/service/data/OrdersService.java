package com.xwwwww.purchaseplatform.service.data;

import com.xwwwww.purchaseplatform.entity.shopping.order.Orders;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface OrdersService {
    Result getOrdersByShop(int shopId) throws Exception;

    Result getOrderStatusNumber(int customerId) throws Exception;

    Result getOrderByCommodityId(int commodityId) throws Exception;

    Result getOrderByCustomerId(int customerId) throws Exception;

    Result getOrderByStatus(int orderStatus) throws Exception;

    Result getOrderByStatus(Orders order) throws Exception;

    Result insertOrder(Orders order) throws Exception;

    Result deleteOrder(int id) throws Exception;

    Result updateOrder(Orders order) throws  Exception;

    Result getAllOrder() throws Exception;
}
