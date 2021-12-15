package com.xwwwww.purchaseplatform.service.customer;

import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public Customer getCustomerByNickName(String nickName) throws Exception;

    public int insertCustomer(Customer customer) throws Exception;

    public int updateCustomer(Customer customer) throws Exception;

    public int deleteCustomerByid(int id) throws Exception;

    public List<Customer> getAllCustomers() throws Exception;

    public List<Customer> getAllUsers() throws Exception;

    public List<Customer> getAllCompanyStaff() throws Exception;
}
