package com.xwwwww.purchaseplatform.controller.constant;

import com.xwwwww.purchaseplatform.entity.administration.administrator.PlatformAdministrator;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Search;
import com.xwwwww.purchaseplatform.mapper.administration.administrator.PlatformAdministratorMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.SearchMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="不用测")
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
