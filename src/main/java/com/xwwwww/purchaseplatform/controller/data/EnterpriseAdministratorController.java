package com.xwwwww.purchaseplatform.controller.data;

import com.xwwwww.purchaseplatform.entity.administration.administrator.EnterpriseAdministrator;
import com.xwwwww.purchaseplatform.service.data.EnterpriseAdministratorService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="企业管理员模块")
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class EnterpriseAdministratorController {
    @Autowired
    EnterpriseAdministratorService enterpriseAdministratorService;

    @ApiOperation(value="根据id获取数据")
    @ResponseBody
    @GetMapping("/enterpriseAdmin")
    Result getEnterpriseAdminById(int id) throws Exception{
        return enterpriseAdministratorService.getEnterpriseAdminById(id);
    }

    @ApiOperation(value="添加数据")
    @ResponseBody
    @PostMapping("/enterpriseAdmin")
    public Result insertEnterpriseAdmin(EnterpriseAdministrator enterpriseAdministrator) throws Exception{
        return enterpriseAdministratorService.insertEnterpriseAdmin(enterpriseAdministrator);
    }

    @ApiOperation(value="删除数据")
    @ResponseBody
    @DeleteMapping("/enterpriseAdmin")
    public Result deleteEnterAdmin(int id) throws Exception{
        return enterpriseAdministratorService.deleteEnterAdmin(id);
    }

    @ApiOperation(value="修改数据")
    @ResponseBody
    @PutMapping("/enterpriseAdmin")
    public Result updateEnterAdmin(EnterpriseAdministrator enterpriseAdministrator) throws Exception{
        return enterpriseAdministratorService.updateEnterAdmin(enterpriseAdministrator);
    }

    @ApiOperation(value="获取所有数据")
    @ResponseBody
    @GetMapping("/enterpriseAdmin/all")
    public Result getAllEnterpriseAdmin() throws Exception{
        return enterpriseAdministratorService.getAllEnterpriseAdmin();
    }
}
