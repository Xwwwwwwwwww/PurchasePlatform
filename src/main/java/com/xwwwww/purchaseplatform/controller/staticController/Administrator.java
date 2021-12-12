package com.xwwwww.purchaseplatform.controller.staticController;

import com.xwwwww.purchaseplatform.mapper.shopping.customer.CustomerMapper;
import com.xwwwww.purchaseplatform.service.login.LoginService;
import com.xwwwww.purchaseplatform.utils.token.AesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/html")
public class Administrator {

    @Autowired
    CustomerMapper customerMapper;

    @GetMapping("/index")
    public String toIndex(Map<String,Object> map,@CookieValue("token") String token) throws Exception{
        String phoneNumber = AesUtils.decrypt(token);
        if(customerMapper.getByPhoneNumber(phoneNumber)!=null)map.put("user",phoneNumber);
        System.out.println(map.get("user"));
        return "index";
    }
}
