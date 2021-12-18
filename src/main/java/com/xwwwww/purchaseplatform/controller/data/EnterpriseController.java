package com.xwwwww.purchaseplatform.controller.data;

import com.xwwwww.purchaseplatform.entity.administration.enterprise.Enterprise;
import com.xwwwww.purchaseplatform.service.admin.EnterpriseService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/data")
public class EnterpriseController {
    @Autowired
    EnterpriseService enterpriseService;

    @ResponseBody
    @GetMapping("/enterprise")
    public Result getEnterpriseById(int id) throws Exception{
        return enterpriseService.getEnterpriseById(id);
    }

    @ResponseBody
    @PostMapping("/enterprise")
    public Result insertEnterprise(@RequestBody Enterprise enterprise)throws Exception{
        return enterpriseService.insertEnterprise(enterprise);
    }

    @ResponseBody
    @DeleteMapping("/enterprise")
    public Result deleteEnterprise(int id) throws Exception{
        return enterpriseService.deleteEnterprise(id);
    }

    @ResponseBody
    @PutMapping("/enterprise")
    public Result updateEnterprise(Enterprise enterprise) throws Exception{
        return enterpriseService.updateEnterprise(enterprise);
    }
}
