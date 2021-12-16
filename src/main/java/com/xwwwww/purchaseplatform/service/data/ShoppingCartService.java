package com.xwwwww.purchaseplatform.service.data;

import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCart;
import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCartDisplay;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShoppingCartService {
    public Result getShoppingCartByCustomerId(int customer_id) throws Exception;
}
