package com.xwwwww.purchaseplatform.controller.staticController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.administration.administrator.EnterpriseAdministrator;
import com.xwwwww.purchaseplatform.entity.administration.administrator.PlatformAdministrator;
import com.xwwwww.purchaseplatform.entity.administration.administrator.Shopkeeper;
import com.xwwwww.purchaseplatform.entity.administration.enterprise.Enterprise;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.mapper.administration.administrator.EnterpriseAdministratorMapper;
import com.xwwwww.purchaseplatform.mapper.administration.administrator.PlatformAdministratorMapper;
import com.xwwwww.purchaseplatform.mapper.administration.administrator.ShopkeeperMapper;
import com.xwwwww.purchaseplatform.mapper.administration.enterprise.EnterpriseMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.CustomerMapper;
import com.xwwwww.purchaseplatform.service.enterprise.EnterpriseService;
import com.xwwwww.purchaseplatform.service.login.LoginService;
import com.xwwwww.purchaseplatform.utils.token.AesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/html")
public class AdministratorMainController {
    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    EnterpriseAdministratorMapper enterpriseAdministratorMapper;

    @Autowired
    PlatformAdministratorMapper platformAdministratorMapper;

    @Autowired
    ShopkeeperMapper shopkeeperMapper;

    @Autowired
    EnterpriseMapper enterpriseMapper;

//    @Autowired
//    private EnterpriseService enterpriseService;

    QueryWrapper<EnterpriseAdministrator> enterpriseAdministratorQueryWrapper=new QueryWrapper<>();
    QueryWrapper<PlatformAdministrator> platformAdministratorQueryWrapper=new QueryWrapper<>();
    QueryWrapper<Shopkeeper> shopkeeperQueryWrapper=new QueryWrapper<>();

    @GetMapping("/index")
    public String toIndex(String token) throws Exception{
        String username=AesUtils.decrypt(token);

        enterpriseAdministratorQueryWrapper.eq("user_Name",username);
        platformAdministratorQueryWrapper.eq("user_Name",username);
        shopkeeperQueryWrapper.eq("user_Name",username);

        if(enterpriseAdministratorMapper.selectOne(enterpriseAdministratorQueryWrapper)!=null)
        {
//            map.put("admin",username);
//            System.out.println(map.get("admin"));
            return "enterpriseAdministratorIndex";
        }
        else if(platformAdministratorMapper.selectOne(platformAdministratorQueryWrapper)!=null)
        {
//            map.put("admin",username);
//            System.out.println(map.get("admin"));
            return "platformAdministratorIndex";
        }
        else if(shopkeeperMapper.selectOne(shopkeeperQueryWrapper)!=null)
        {
//            map.put("admin",username);
//            System.out.println(map.get("admin"));
            return "shopkeeperIndex";
        }
        else
        {
            return "error";
        }
    }

    @GetMapping("/order")
    public String toOrder(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        shopkeeperQueryWrapper.eq("user_Name",username);
        if (shopkeeperMapper.selectOne(shopkeeperQueryWrapper)!=null)
            return "order";
        else
            return "error";
    }

    @GetMapping("/commodity")
    public String toCommodity(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        shopkeeperQueryWrapper.eq("user_Name",username);
        if (shopkeeperMapper.selectOne(shopkeeperQueryWrapper)!=null)
            return "commodity";
        else
            return "error";
    }

    @GetMapping("/freight")
    public String toFreight(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        shopkeeperQueryWrapper.eq("user_Name",username);
        if (shopkeeperMapper.selectOne(shopkeeperQueryWrapper)!=null)
            return "freight";
        else
            return "error";
    }

    @GetMapping("/afterSale")
    public String toAfterSale(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        shopkeeperQueryWrapper.eq("user_Name",username);
        if (shopkeeperMapper.selectOne(shopkeeperQueryWrapper)!=null)
            return "afterSale";
        else
            return "error";
    }

    @GetMapping("/statistics")
    public String toStatistics(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        shopkeeperQueryWrapper.eq("user_Name",username);
        platformAdministratorQueryWrapper.eq("user_Name",username);
        if (shopkeeperMapper.selectOne(shopkeeperQueryWrapper)!=null)
            return "shopStatistics";
        else if(platformAdministratorMapper.selectOne(platformAdministratorQueryWrapper)!=null)
            return "platformStatistics";
        else
            return "error";
    }

    @GetMapping("/shop")
    public String toShop(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        shopkeeperQueryWrapper.eq("user_Name",username);
        if (shopkeeperMapper.selectOne(shopkeeperQueryWrapper)!=null)
            return "shop";
        else
            return "error";
    }

    @GetMapping("/operation")
    public String toOperation(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        shopkeeperQueryWrapper.eq("user_Name",username);
        if (shopkeeperMapper.selectOne(shopkeeperQueryWrapper)!=null)
            return "operation";
        else
            return "error";
    }

    @GetMapping("/system")
    public String toSystem(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        platformAdministratorQueryWrapper.eq("user_Name",username);
        if (platformAdministratorMapper.selectOne(platformAdministratorQueryWrapper)!=null)
            return "system";
        else
            return "error";
    }

    @GetMapping("/information")
    public String toInformation(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        platformAdministratorQueryWrapper.eq("user_Name",username);
        if (platformAdministratorMapper.selectOne(platformAdministratorQueryWrapper)!=null)
            return "information";
        else
            return "error";
    }

    @GetMapping("/register")
    public String toRegister(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        platformAdministratorQueryWrapper.eq("user_Name",username);
        if (platformAdministratorMapper.selectOne(platformAdministratorQueryWrapper)!=null)
            return "register";
        else
            return "error";
    }

    @GetMapping("/account")
    public String toAccount(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
       enterpriseAdministratorQueryWrapper.eq("user_Name",username);
        if (enterpriseAdministratorMapper.selectOne(enterpriseAdministratorQueryWrapper)!=null)
            return "account";
        else
            return "error";
    }

    @ResponseBody
    @CrossOrigin
    @GetMapping("/enterprise/all")
    public List<Enterprise> getAllEnterprises() throws Exception{
        return enterpriseMapper.getAllEnterprise();
    }
}
