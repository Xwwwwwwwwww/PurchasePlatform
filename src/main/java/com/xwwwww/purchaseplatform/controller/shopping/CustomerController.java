package com.xwwwww.purchaseplatform.controller.shopping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.CustomerMapper;
import com.xwwwww.purchaseplatform.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @DeleteMapping("/customer")
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
    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers() throws Exception{
        return customerService.getAllCustomers();
    }

    @ResponseBody
    @GetMapping("/customerById")
    public Customer getCustomersById(int id) throws Exception{
        return customerService.getCustomerById(id);
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
