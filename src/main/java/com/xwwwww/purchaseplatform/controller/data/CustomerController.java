package com.xwwwww.purchaseplatform.controller.data;

import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.service.data.CustomerService;
import com.xwwwww.purchaseplatform.utils.result.Result;
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
    public Result insertCustomer(@RequestBody Customer customer) throws  Exception{
        return customerService.insertCustomer(customer);
    }

    @ResponseBody
    @PutMapping("/customer")
    public Result updateCustomer(@RequestBody Customer customer) throws  Exception{
        System.out.println("controller"+customer);
        return customerService.updateCustomer(customer);
    }

    @ResponseBody
    @DeleteMapping("/customer")
    public Result deleteCustomerById(int id) throws Exception{
        return customerService.deleteCustomerById(id);
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
    /**
     *
     * @param enterpriseId
     * @return
     * @throws Exception
     * 根据企业id查询企业员工
     */
    @ResponseBody
    @GetMapping("/customer/all/companystaff/id")
    public Result getCompanyStaffById(@RequestParam int enterpriseId) throws Exception{
        return customerService.getCompanyStaffById(enterpriseId);
    }
}


