package com.xwwwww.purchaseplatform.mapper.shopping.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
    public Integer deleteOneItem(@Param("customerId") int customerId, @Param("commodityId") int commodityId);
}
