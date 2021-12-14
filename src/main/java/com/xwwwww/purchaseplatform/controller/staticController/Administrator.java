package com.xwwwww.purchaseplatform.controller.staticController;

import com.xwwwww.purchaseplatform.mapper.shopping.customer.CustomerMapper;
import com.xwwwww.purchaseplatform.service.login.LoginService;
import com.xwwwww.purchaseplatform.utils.token.AesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/html")
public class Administrator {

    @Autowired
    CustomerMapper customerMapper;

    @GetMapping("/index")
    public String toIndex(String token) throws Exception{
        String phoneNumber = AesUtils.decrypt(token);
        if(customerMapper.getByPhoneNumber(phoneNumber)!=null)return phoneNumber;
        else return "index";
    }
}
