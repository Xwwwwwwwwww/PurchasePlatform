package com.xwwwww.purchaseplatform.service.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCart;
import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCartDisplay;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.size.SizeMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.commodity.CommodityMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.ShoppingCartMapper;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Autowired
    CommodityMapper commodityMapper;

    @Autowired
    SizeMapper sizeMapper;

    @Override
    public Result getShoppingCartByCustomerId(int customer_id) throws Exception {
        List<ShoppingCartDisplay> shoppingCartDisplayList=new ArrayList<>();    //返回的data
        QueryWrapper<ShoppingCart> shoppingCartQueryWrapper=new QueryWrapper<>();
        shoppingCartQueryWrapper.eq("customer_id",customer_id);
        List<ShoppingCart> shoppingCartList = shoppingCartMapper.selectList(shoppingCartQueryWrapper);
        for (ShoppingCart shoppingCart : shoppingCartList) {
            ShoppingCartDisplay shoppingCartDisplay=new ShoppingCartDisplay();
            int commodityId=shoppingCart.getCommodityId();
            Commodity commodity= commodityMapper.selectById(commodityId);
            shoppingCartDisplay.setCustomerId(shoppingCart.getCustomerId());
            shoppingCartDisplay.setCommodityId(shoppingCart.getCommodityId());
            shoppingCartDisplay.setShopName(commodity.getBelongingShopName());
            shoppingCartDisplay.setCommodityName(commodity.getName());
            shoppingCartDisplay.setCommodityPrice(commodity.getPrice());
            shoppingCartDisplay.setShopId(commodity.getBelongingShop());
            shoppingCartDisplay.setQuantity(shoppingCart.getQuantity());
            shoppingCartDisplay.setStock(commodity.getStock());
            shoppingCartDisplay.setSizeId(shoppingCart.getSize());
            shoppingCartDisplay.setSize(sizeMapper.selectById(shoppingCart.getSize()).getDescribes());
            shoppingCartDisplay.setCommodityUrl(commodity.getThumbnailUrl());
            shoppingCartDisplay.setSizeSystem(shoppingCart.getSizeSystem());
            shoppingCartDisplayList.add(shoppingCartDisplay);
        }
        return Result.SUCCESS(shoppingCartDisplayList);
    }
}
