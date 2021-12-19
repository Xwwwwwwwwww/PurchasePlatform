package com.xwwwww.purchaseplatform.mapper.administration.administrator;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xwwwww.purchaseplatform.entity.administration.administrator.PlatformAdministrator;
import com.xwwwww.purchaseplatform.entity.administration.administrator.Shopkeeper;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopkeeperMapper extends BaseMapper<Shopkeeper> {
    Shopkeeper login(Shopkeeper shopkeeper);
}
