package com.xwwwww.purchaseplatform.controller.login;


import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.service.login.LoginService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ResponseBody
    @PostMapping("/login")
    public Result login(Customer customer, HttpServletResponse response) throws Exception{
        System.out.println("phoneNumber:"+customer.getPhoneNumber());
        System.out.println("password:"+customer.getPassword());
        response.setHeader("Access-Control-Allow-Origin", "*");
        return loginService.login(customer.getPhoneNumber(),customer.getPassword());
    }
}
