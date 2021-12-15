package com.xwwwww.purchaseplatform.mapper.shopping.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    public Customer getByNickName(String nickName);

    public Customer login(Customer customer);

    public Customer getByPhoneNumber(String phoneNumber);

    public Customer getByNickNameAndStatus(@Param("nickName") String nickName, @Param("status") int status);
}
