package com.xwwwww.purchaseplatform.service.data;

import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    Customer getCustomerById(int id) throws Exception;

    Customer getCustomerByNickName(String nickName) throws Exception;

    Result insertCustomer(Customer customer) throws Exception;

    Result updateCustomer(Customer customer) throws Exception;

    Result deleteCustomerById(int id) throws Exception;

    List<Customer> getAllCustomers() throws Exception;

    List<Customer> getAllUsers() throws Exception;

    List<Customer> getAllCompanyStaff() throws Exception;

    Result getCompanyStaffById(int enterpriseId) throws Exception;
}
