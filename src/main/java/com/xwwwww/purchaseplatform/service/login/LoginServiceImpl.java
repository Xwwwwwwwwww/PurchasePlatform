package com.xwwwww.purchaseplatform.service.login;

import com.xwwwww.purchaseplatform.entity.administration.administrator.Admin;
import com.xwwwww.purchaseplatform.entity.administration.administrator.EnterpriseAdministrator;
import com.xwwwww.purchaseplatform.entity.administration.administrator.PlatformAdministrator;
import com.xwwwww.purchaseplatform.entity.administration.administrator.Shopkeeper;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.mapper.administration.administrator.EnterpriseAdministratorMapper;
import com.xwwwww.purchaseplatform.mapper.administration.administrator.PlatformAdministratorMapper;
import com.xwwwww.purchaseplatform.mapper.administration.administrator.ShopkeeperMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.CustomerMapper;
import com.xwwwww.purchaseplatform.utils.result.Result;
import com.xwwwww.purchaseplatform.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    PlatformAdministratorMapper platformAdministratorMapper;

    @Autowired
    ShopkeeperMapper shopkeeperMapper;

    @Autowired
    EnterpriseAdministratorMapper enterpriseAdministratorMapper;

    @Override
    public Result login(Customer customer) throws Exception{
        Customer customer1=customerMapper.login(customer);
        if (customer1==null)
            return new Result(ResultCode.USER_LOGIN_ERROR,"error");
        return Result.SUCCESS(customer1);
    }

    @Override
    public Result login(Admin admin) throws Exception{
        System.out.println("admin打印 service里:"+admin);
        if (admin.getFlag()==1){
            //平台管理员
            PlatformAdministrator platformAdministrator=new PlatformAdministrator();
            platformAdministrator.setUserName(admin.getUserName());
            platformAdministrator.setPassword(admin.getPassword());
            PlatformAdministrator platformAdministrator1=platformAdministratorMapper.login(platformAdministrator);
            if (platformAdministrator1==null)
                return new Result(ResultCode.USER_LOGIN_ERROR,"error");
            return Result.SUCCESS(platformAdministrator1);

        }
        else if (admin.getFlag()==2){
            //店铺管理员
            Shopkeeper shopkeeper=new Shopkeeper();
            shopkeeper.setUserName(admin.getUserName());
            shopkeeper.setPassword(admin.getPassword());
            Shopkeeper shopkeeper1=shopkeeperMapper.login(shopkeeper);
            if (shopkeeper1==null)
                return new Result(ResultCode.USER_LOGIN_ERROR,"error");
            return Result.SUCCESS(shopkeeper1);
        }
        else if (admin.getFlag()==3){
            //企业管理员
            EnterpriseAdministrator enterpriseAdministrator=new EnterpriseAdministrator();
            enterpriseAdministrator.setUserName(admin.getUserName());
            enterpriseAdministrator.setPassword(admin.getPassword());
            EnterpriseAdministrator enterpriseAdministrator1=enterpriseAdministratorMapper.login(enterpriseAdministrator);
            if (enterpriseAdministrator1==null)
                return new Result(ResultCode.USER_LOGIN_ERROR,"error");
            return Result.SUCCESS(enterpriseAdministrator1);
        }
        else {
            return Result.FAIL("不是任何一种管理员");
        }
    }
}
