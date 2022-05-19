package com.xwwwww.purchaseplatform.controller.constant;

import com.xwwwww.purchaseplatform.entity.administration.enterprise.Enterprise;
import com.xwwwww.purchaseplatform.service.data.EnterpriseService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="企业模块（可以考虑不测）")
@CrossOrigin
@RestController
@RequestMapping("/data")
public class EnterpriseController {
    @Autowired
    EnterpriseService enterpriseService;

    @ApiOperation(value="根据id获取数据")
    @ResponseBody
    @GetMapping("/enterprise")
    public Result getEnterpriseById(int id) throws Exception{
        return enterpriseService.getEnterpriseById(id);
    }

    @ApiOperation(value="添加数据")
    @ResponseBody
    @PostMapping("/enterprise")
    public Result insertEnterprise(@RequestBody Enterprise enterprise)throws Exception{
        return enterpriseService.insertEnterprise(enterprise);
    }

    @ApiOperation(value="删除数据")
    @ResponseBody
    @DeleteMapping("/enterprise")
    public Result deleteEnterprise(int id) throws Exception{
        return enterpriseService.deleteEnterprise(id);
    }

    @ApiOperation(value="修改数据")
    @ResponseBody
    @PutMapping("/enterprise")
    public Result updateEnterprise(Enterprise enterprise) throws Exception{
        return enterpriseService.updateEnterprise(enterprise);
    }

    @ApiOperation(value="获取所有数据")
    @ResponseBody
    @GetMapping("/enterprise/all")
    public Result getEnterprises() throws Exception{
        return enterpriseService.getEnterprises();
    }
}
