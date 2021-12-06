package com.xwwwww.purchaseplatform.mapper.shopping.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    public Customer getByNickName(String nickName);
}
