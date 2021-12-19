package com.xwwwww.purchaseplatform.service.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.administration.administrator.Shopkeeper;
import com.xwwwww.purchaseplatform.entity.shopping.shop.Shop;
import com.xwwwww.purchaseplatform.mapper.shopping.shop.ShopMapper;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    ShopMapper shopMapper;

    @Override
    public Result getShopByShpShopKeeper(Shopkeeper shopKeeper) throws Exception {
        QueryWrapper <Shop> shopQueryWrapper=new QueryWrapper<>();
        shopQueryWrapper.eq("shop_keeper_id",shopKeeper.getUserName());
        return Result.SUCCESS(shopMapper.selectList(shopQueryWrapper));
    }
}

