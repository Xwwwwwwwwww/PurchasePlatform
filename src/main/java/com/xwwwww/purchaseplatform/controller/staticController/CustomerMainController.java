package com.xwwwww.purchaseplatform.controller.staticController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.CustomerMapper;
import com.xwwwww.purchaseplatform.utils.token.AesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/html")
public class CustomerMainController {
    @Autowired
    CustomerMapper customerMapper;

    QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();

    @GetMapping("/customerIndex")
    public String toIndex(Map<String,Object> map, @CookieValue("token") String token) throws Exception{
        String username= AesUtils.decrypt(token);

        queryWrapper.eq("nick_Name",username);

        if(customerMapper.selectOne(queryWrapper)!=null)
        {
            map.put("customer",username);
            System.out.println(map.get("customer"));
            return "enterpriseAdministratorIndex";
        }
        else
        {
            return "error";
        }
    }

    @GetMapping("/search")
    public String toSearch(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        queryWrapper.eq("nick_Name",username);
        if (customerMapper.selectOne(queryWrapper)!=null)
            return "search";
        else
            return "error";
    }

    @GetMapping("/collection")
    public String toCollection(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        queryWrapper.eq("nick_Name",username);
        if (customerMapper.selectOne(queryWrapper)!=null)
            return "collection";
        else
            return "error";
    }

    @GetMapping("/customerInfo")
    public String toCustomerInfo(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        queryWrapper.eq("nick_Name",username);
        if (customerMapper.selectOne(queryWrapper)!=null)
            return "customerInfo";
        else
            return "error";
    }

    @GetMapping("/customerOrder")
    public String toCustomerOrder(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        queryWrapper.eq("nick_Name",username);
        if (customerMapper.selectOne(queryWrapper)!=null)
            return "customerInfo";
        else
            return "error";
    }

    @GetMapping("/shoppingCart")
    public String toShoppingCart(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        queryWrapper.eq("nick_Name",username);
        if (customerMapper.selectOne(queryWrapper)!=null)
            return "shoppingCart";
        else
            return "error";
    }

    @GetMapping("/returnCommodity")
    public String toReturnCommodity(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        queryWrapper.eq("nick_Name",username);
        if (customerMapper.selectOne(queryWrapper)!=null)
            return "returnCommodity";
        else
            return "error";
    }

    @GetMapping("/staffRegister")
    public String toStaffRegister(@CookieValue("token") String token) throws Exception{
        String username=AesUtils.decrypt(token);
        if (customerMapper.getByNickNameAndStatus(username,0)!=null)
            return "staffRegister";
        else
            return "error";
    }


}
