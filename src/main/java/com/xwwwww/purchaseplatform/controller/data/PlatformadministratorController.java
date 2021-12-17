package com.xwwwww.purchaseplatform.controller.data;

import com.xwwwww.purchaseplatform.entity.administration.administrator.PlatformAdministrator;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Search;
import com.xwwwww.purchaseplatform.mapper.administration.administrator.PlatformAdministratorMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/data")
public class PlatformadministratorController {
    @Autowired
    PlatformAdministratorMapper platformAdministratorMapper;

    @ResponseBody
    @GetMapping("/platformadministrator")
    public PlatformAdministrator login(int id) throws Exception{
        return platformAdministratorMapper.selectById(id);
    }
}
