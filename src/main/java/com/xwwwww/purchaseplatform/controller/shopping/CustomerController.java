package com.xwwwww.purchaseplatform.controller.shopping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.CustomerMapper;
import com.xwwwww.purchaseplatform.service.customer.CustomerService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @ResponseBody
    @GetMapping("/customer")
    public Customer getCustomerByNickName(String nickName) throws Exception{
        return customerService.getCustomerByNickName(nickName);
    }

    @ResponseBody
    @PostMapping("/customer")
    public int insertCustomer(Customer customer) throws  Exception{
        return customerService.insertCustomer(customer);
    }

    @ResponseBody
    @PutMapping("/customer")
    public int updateCustomer(Customer customer) throws  Exception{
        return customerService.updateCustomer(customer);
    }

    @ResponseBody
    @CrossOrigin
    @DeleteMapping("/deletecustomer")
    public int deleteCustomerByid(int id) throws Exception{
        return customerService.deleteCustomerByid(id);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有顾客
     */
    @ResponseBody
    @CrossOrigin
    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers() throws Exception{
        return customerService.getAllCustomers();
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有普通用户
     */
    @ResponseBody
    @CrossOrigin
    @GetMapping("/customer/all/user")
    public List<Customer> getAllUsers() throws Exception{
        //System.out.println("调用了！");
        return customerService.getAllUsers();
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
        return customerService.getAllCompanyStaff();
    }
}
