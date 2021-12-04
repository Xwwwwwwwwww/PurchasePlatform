package com.xwwwww.purchaseplatform.controller.login;


import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.service.login.LoginService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ResponseBody
    @PostMapping("/login")
    public Result login(@RequestBody Customer customer) throws Exception{
        System.out.println("phoneNumber:"+customer.getPhoneNumber());
        System.out.println("password:"+customer.getPassword());
        return loginService.login(customer.getPhoneNumber(),customer.getPassword());
    }
}
