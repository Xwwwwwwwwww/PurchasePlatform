package com.xwwwww.purchaseplatform.service.data.Impl;

import com.xwwwww.purchaseplatform.entity.administration.administrator.EnterpriseAdministrator;
import com.xwwwww.purchaseplatform.mapper.administration.administrator.EnterpriseAdministratorMapper;
import com.xwwwww.purchaseplatform.service.data.EnterpriseAdministratorService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class
EnterpriseAdministratorServiceImpl implements EnterpriseAdministratorService {
    @Autowired
    EnterpriseAdministratorMapper enterpriseAdministratorMapper;

    @Override
    public Result getEnterpriseAdminById(int id) throws Exception {
        return Result.SUCCESS(enterpriseAdministratorMapper.selectById(id));
    }

    @Override
    public Result insertEnterpriseAdmin(EnterpriseAdministrator enterpriseAdministrator) throws Exception {
        enterpriseAdministratorMapper.insert(enterpriseAdministrator);
        return Result.SUCCESS(enterpriseAdministrator.getId());
    }

    @Override
    public Result deleteEnterAdmin(int id) throws Exception {
        enterpriseAdministratorMapper.deleteById(id);
        return Result.SUCCESS();
    }

    @Override
    public Result updateEnterAdmin(EnterpriseAdministrator enterpriseAdministrator) throws Exception {
        enterpriseAdministratorMapper.updateById(enterpriseAdministrator);
        return Result.SUCCESS();
    }

    @Override
    public Result getAllEnterpriseAdmin() throws Exception {
        return Result.SUCCESS(enterpriseAdministratorMapper.selectList(null));
    }
}
