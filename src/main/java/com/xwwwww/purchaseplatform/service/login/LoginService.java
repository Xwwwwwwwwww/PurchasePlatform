package com.xwwwww.purchaseplatform.service.login;

import com.xwwwww.purchaseplatform.entity.administration.administrator.Admin;
import com.xwwwww.purchaseplatform.entity.administration.administrator.PlatformAdministrator;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    Result login(Customer customer) throws Exception;

    Result login(Admin admin) throws Exception;
}
