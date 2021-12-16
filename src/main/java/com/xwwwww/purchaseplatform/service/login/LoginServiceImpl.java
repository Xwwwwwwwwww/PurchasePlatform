package com.xwwwww.purchaseplatform.service.login;

import com.xwwwww.purchaseplatform.entity.administration.administrator.PlatformAdministrator;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.mapper.administration.administrator.PlatformAdministratorMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.CustomerMapper;
import com.xwwwww.purchaseplatform.utils.result.Result;
import com.xwwwww.purchaseplatform.utils.result.ResultCode;
import com.xwwwww.purchaseplatform.utils.token.AesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    PlatformAdministratorMapper platformAdministratorMapper;
    @Override
    public Result login(Customer customer) throws Exception{
        if(customerMapper.login(customer)!=null)
            return Result.SUCCESS(AesUtils.encrypt(customer.getPhoneNumber()));
        else
            return new Result(ResultCode.USER_LOGIN_ERROR,"error");
    }
    @Override
    public Result login(PlatformAdministrator platformAdministrator) throws Exception{
        if(platformAdministratorMapper.login(platformAdministrator)!=null)
            return Result.SUCCESS(AesUtils.encrypt(platformAdministrator.getUserName()));
        else
            return new Result(ResultCode.USER_LOGIN_ERROR,"error");
    }
}
