package com.xwwwww.purchaseplatform.controller.shopping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class CustomerController {
    @Autowired
    CustomerMapper customerMapper;

    @ResponseBody
    @GetMapping("/customer")
    public Customer getCustomerByNickName(String nickName) throws Exception{
        return customerMapper.getByNickName(nickName);
    }

    @ResponseBody
    @PostMapping("/customer")
    public int insertCustomer(Customer customer) throws  Exception{
        return customerMapper.insert(customer);
    }

    @ResponseBody
    @PutMapping("/customer")
    public int updateCustomer(Customer customer) throws  Exception{
        return customerMapper.updateById(customer);
    }

    @ResponseBody
    @DeleteMapping("/customer")
    public int deleteCustomerByid(int id) throws Exception{
        return customerMapper.deleteById(id);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有顾客
     */
    @ResponseBody
    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers() throws Exception{
        return customerMapper.selectList(null);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有普通用户
     */
    @ResponseBody
    @GetMapping("/customer/all/user")
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
    @ResponseBody
    @GetMapping("/customer/all/companystaff")
    public List<Customer> getAllCompanyStaff() throws Exception{
        QueryWrapper<Customer> customerQueryWrapper=new QueryWrapper<>();
        //身份编号是1代表企业员工
        customerQueryWrapper.eq("identity",1);
        return customerMapper.selectList(customerQueryWrapper);
    }
}
