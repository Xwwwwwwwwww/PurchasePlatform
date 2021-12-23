package com.xwwwww.purchaseplatform.mapper.shopping.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xwwwww.purchaseplatform.entity.shopping.order.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
    List<Orders> getOrderByCustomerAndStatus(Orders order) throws Exception;

}
