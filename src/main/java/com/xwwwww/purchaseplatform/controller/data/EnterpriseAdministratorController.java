package com.xwwwww.purchaseplatform.controller.data;

import com.xwwwww.purchaseplatform.entity.administration.administrator.EnterpriseAdministrator;
import com.xwwwww.purchaseplatform.service.data.EnterpriseAdministratorService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/admin")
public class EnterpriseAdministratorController {
    @Autowired
    EnterpriseAdministratorService enterpriseAdministratorService;

    @ResponseBody
    @GetMapping("/enterpriseAdmin")
    Result getEnterpriseAdminById(int id) throws Exception{
        return enterpriseAdministratorService.getEnterpriseAdminById(id);
    }

    @ResponseBody
    @PostMapping("/enterpriseAdmin")
    public Result insertEnterpriseAdmin(EnterpriseAdministrator enterpriseAdministrator) throws Exception{
        return enterpriseAdministratorService.insertEnterpriseAdmin(enterpriseAdministrator);
    }

    @ResponseBody
    @DeleteMapping("/enterpriseAdmin")
    public Result deleteEnterAdmin(int id) throws Exception{
        return enterpriseAdministratorService.deleteEnterAdmin(id);
    }

    @ResponseBody
    @PutMapping("/enterpriseAdmin")
    public Result updateEnterAdmin(EnterpriseAdministrator enterpriseAdministrator) throws Exception{
        return enterpriseAdministratorService.updateEnterAdmin(enterpriseAdministrator);
    }

    @ResponseBody
    @GetMapping("/enterpriseAdmin/all")
    public Result getAllEnterpriseAdmin() throws Exception{
        return enterpriseAdministratorService.getAllEnterpriseAdmin();
    }
}
