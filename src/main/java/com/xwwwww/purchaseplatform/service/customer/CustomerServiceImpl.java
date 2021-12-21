package com.xwwwww.purchaseplatform.service.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.mapper.shopping.commodity.CommodityMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.CustomerMapper;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Customer getCustomerById(int id) throws Exception {
        return customerMapper.selectById(id);
    }

    /**
     *
     * @param nickName
     * @return Customer
     * @throws Exception
     * 根据昵称查询顾客
     */
    public Customer getCustomerByNickName(String nickName) throws Exception{
        return customerMapper.getByNickName(nickName);
    }

    /**
     *
     * @param customer
     * @return int
     * @throws Exception
     * 添加顾客
     */
    public int insertCustomer(Customer customer) throws  Exception{
        return customerMapper.insert(customer);
    }

    /**
     *
     * @param customer
     * @return int
     * @throws Exception
     * 更新顾客信息
     */
    public int updateCustomer(Customer customer) throws  Exception{
        System.out.println(customer);
        return customerMapper.updateById(customer);
    }

    /**
     *
     * @param id
     * @return int
     * @throws Exception
     * 删除顾客
     */
    public int deleteCustomerById(int id) throws Exception{
        return customerMapper.deleteById(id);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有顾客
     */
    public List<Customer> getAllCustomers() throws Exception{
        return customerMapper.getAllCustomers();
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有普通用户
     */
    public List<Customer> getAllUsers() throws Exception{
        QueryWrapper<Customer> customerQueryWrapper=new QueryWrapper<>();
        //身份编号是0代表普通员工
        customerQueryWrapper.eq("identity",0);
        return customerMapper.selectList(customerQueryWrapper);
    }
    /**
     *
     * @return list
     * @throws Exception
     * 查询所有企业员工
     */
    public List<Customer> getAllCompanyStaff() throws Exception{
        QueryWrapper<Customer> customerQueryWrapper=new QueryWrapper<>();
        //身份编号是1代表企业员工
        customerQueryWrapper.eq("identity",1);
        return customerMapper.selectList(customerQueryWrapper);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有企业员工
     */
    @Override
    public Result getCompanyStaffById(int enterpriseId) throws Exception {
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("belonging_enterprise",enterpriseId);
        return Result.SUCCESS(customerMapper.selectList(queryWrapper));
    }
}
