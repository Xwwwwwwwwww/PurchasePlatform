package com.xwwwww.purchaseplatform.service.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCart;
import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCollection;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.ShoppingCollectionMapper;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCollectionServiceImpl implements ShoppingCollectionService{
    @Autowired
    ShoppingCollectionMapper shoppingCollectionMapper;

    @Override
    public Result getShoppingCollectionItemsNumber(int customerId) throws Exception {
        QueryWrapper<ShoppingCollection> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("customer_Id",customerId);
        List<ShoppingCollection> shoppingCollectionList=shoppingCollectionMapper.selectList(queryWrapper);
        int number=shoppingCollectionList.size();
        return Result.SUCCESS(number);
    }
}
