package com.xwwwww.purchaseplatform.service.data;

import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCart;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface ShoppingCartService {
    Result getShoppingCartByCustomerId(int customer_id) throws Exception;

    Result getShoppingCartByCommodityId(int commodityId) throws Exception;

    Result insertShoppingCart(ShoppingCart shoppingCart) throws Exception;

    Result deleteShoppingCart(int id) throws Exception;

    Result updateShoppingCart(ShoppingCart shoppingCart) throws  Exception;

    Result getAllShoppingCarts() throws Exception;

    Result inShoppingCart(ShoppingCart shoppingCart) throws Exception;
}
