package com.xwwwww.purchaseplatform.service.data;

import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCollection;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCollectionService {
    Result getShoppingCollectionItemsNumber(int customerId)throws Exception;

    Result insertShoppingCollection(ShoppingCollection shoppingCollection) throws Exception;

    Result deleteShoppingCollection(int id) throws Exception;

    Result updateShoppingCollection(ShoppingCollection shoppingCollection);

    Result getAllShoppingCollection() throws Exception;

    Result getShoppingCollectionByCustomerId(int customer_id) throws  Exception;
}
