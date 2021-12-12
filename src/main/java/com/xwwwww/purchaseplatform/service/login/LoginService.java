package com.xwwwww.purchaseplatform.service.login;

import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public Result login(Customer customer) throws Exception;
}
