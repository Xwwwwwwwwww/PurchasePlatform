package com.xwwwww.purchaseplatform.service.data;

import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {
    public Result getShoppingCartByCustomerId(int customer_id) throws Exception;
}
