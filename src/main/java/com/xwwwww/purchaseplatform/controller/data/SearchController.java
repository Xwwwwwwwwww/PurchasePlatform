package com.xwwwww.purchaseplatform.controller.data;


import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Search;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.SearchMapper;
import com.xwwwww.purchaseplatform.service.login.LoginService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class SearchController {
    @Autowired
    SearchMapper searchMapper;

    @ResponseBody
    @GetMapping("/search")
    public Search login(int id) throws Exception{
        return searchMapper.selectById(id);
    }
}
