package com.xwwwww.purchaseplatform.service.data;

import com.xwwwww.purchaseplatform.entity.administration.administrator.Shopkeeper;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface ShopService {
    Result getShopByShpShopKeeper(Shopkeeper shopKeeper) throws Exception;
}
