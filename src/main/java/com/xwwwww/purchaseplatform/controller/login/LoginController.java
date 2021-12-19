package com.xwwwww.purchaseplatform.controller.login;


import com.xwwwww.purchaseplatform.entity.administration.administrator.PlatformAdministrator;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.service.login.LoginService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import com.xwwwww.purchaseplatform.utils.token.AesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ResponseBody
    @PostMapping("/customer")
    public Result login(Customer customer) throws Exception{
        return  loginService.login(customer);
    }
    @ResponseBody
    @PostMapping("/platformAdministrator/login")
    public Result login(PlatformAdministrator platformAdministrator) throws Exception{
        return  loginService.login(platformAdministrator);
    }
}
