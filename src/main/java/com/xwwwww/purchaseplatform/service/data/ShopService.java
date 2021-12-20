package com.xwwwww.purchaseplatform.service.data;

import com.xwwwww.purchaseplatform.entity.administration.administrator.Shopkeeper;
import com.xwwwww.purchaseplatform.entity.shopping.shop.Shop;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface ShopService {
    Result getShopByShpShopKeeper(Shopkeeper shopKeeper) throws Exception;

    Result getShopById(int id) throws Exception;

    Result getShopByName(String name) throws Exception;

    Result insertShop(Shop shop) throws Exception;

    Result deleteShop(int id) throws Exception;

    Result updateShop(Shop shop) throws  Exception;

    Result getAllShops() throws Exception;
}
