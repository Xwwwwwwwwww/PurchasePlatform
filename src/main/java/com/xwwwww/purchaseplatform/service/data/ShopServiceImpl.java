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

    @Override
    public Result getShopById(int id) throws Exception {
        return Result.SUCCESS(shopMapper.selectById(id));
    }

    @Override
    public Result getShopByName(String name) throws Exception {
        QueryWrapper<Shop> queryWrapper=new QueryWrapper<>();
        //模糊查询：%value%
        queryWrapper.like("name",name);
        return Result.SUCCESS(shopMapper.selectList(queryWrapper));
    }

    @Override
    public Result insertShop(Shop shop) throws Exception {
        shopMapper.insert(shop);
        return Result.SUCCESS(shop.getId());
    }

    @Override
    public Result deleteShop(int id) throws Exception {
        shopMapper.deleteById((id));
        return Result.SUCCESS();
    }

    @Override
    public Result updateShop(Shop shop) throws Exception {
        shopMapper.updateById(shop);
        return Result.SUCCESS();
    }

    @Override
    public Result getAllShops() throws Exception {
        return Result.SUCCESS(shopMapper.selectList(null));
    }
}

