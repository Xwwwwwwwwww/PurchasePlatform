package com.xwwwww.purchaseplatform.service.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCollection;
import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCollectionDisplay;
import com.xwwwww.purchaseplatform.mapper.shopping.commodity.CommodityMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.ShoppingCollectionMapper;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCollectionServiceImpl implements ShoppingCollectionService{
    @Autowired
    ShoppingCollectionMapper shoppingCollectionMapper;

    @Autowired
    CommodityMapper commodityMapper;

    @Override
    public Result getShoppingCollectionItemsNumber(int customerId) throws Exception {
        QueryWrapper<ShoppingCollection> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("customer_Id",customerId);
        List<ShoppingCollection> shoppingCollectionList=shoppingCollectionMapper.selectList(queryWrapper);
        int number=shoppingCollectionList.size();
        return Result.SUCCESS(number);
    }

    @Override
    public Result insertShoppingCollection(ShoppingCollection shoppingCollection) throws Exception {
        return Result.SUCCESS(shoppingCollectionMapper.insert(shoppingCollection));
    }

    @Override
    public Result deleteShoppingCollection(int id) throws Exception {
        shoppingCollectionMapper.deleteById((id));
        return Result.SUCCESS();
    }

    @Override
    public Result updateShoppingCollection(ShoppingCollection shoppingCollection) {
        shoppingCollectionMapper.updateById(shoppingCollection);
        return Result.SUCCESS();
    }

    @Override
    public Result getAllShoppingCollection() throws Exception {
        return Result.SUCCESS(shoppingCollectionMapper.selectList(null));
    }

    @Override
    public Result getShoppingCollectionByCustomerId(int customerId) throws Exception {
        List<ShoppingCollectionDisplay> shoppingCollectionDisplayList=new ArrayList<>();

        QueryWrapper<ShoppingCollection> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("customer_id",customerId);
        List<ShoppingCollection> shoppingCollection=shoppingCollectionMapper.selectList(queryWrapper);
        for (ShoppingCollection collection : shoppingCollection) {
            ShoppingCollectionDisplay shoppingCollectionDisplay=new ShoppingCollectionDisplay();
            Commodity commodity=commodityMapper.selectById(collection.getCommodityId());
            shoppingCollectionDisplay.setCustomerId(collection.getCustomerId());
            shoppingCollectionDisplay.setCommodityId(collection.getCommodityId());
            shoppingCollectionDisplay.setShopName(commodity.getBelongingShopName());
            shoppingCollectionDisplay.setCommodityName(commodity.getName());
            shoppingCollectionDisplay.setCommodityPrice(commodity.getPrice());
            shoppingCollectionDisplay.setShopId(commodity.getBelongingShop());
            shoppingCollectionDisplay.setStock(commodity.getStock());
            shoppingCollectionDisplay.setCommodityUrl(commodity.getThumbnailUrl());
            shoppingCollectionDisplayList.add(shoppingCollectionDisplay);
        }
        return Result.SUCCESS(shoppingCollectionDisplayList);
    }
}
