package com.xwwwww.purchaseplatform.service.admin;

import com.xwwwww.purchaseplatform.entity.administration.enterprise.Enterprise;
import com.xwwwww.purchaseplatform.mapper.administration.enterprise.EnterpriseMapper;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseServiceImpl implements EnterpriseService{
    @Autowired
    EnterpriseMapper enterpriseMapper;

    @Override
    public Result getEnterpriseById(int id) throws Exception {
        Enterprise enterprise=enterpriseMapper.selectById(id);
        return Result.SUCCESS(enterprise);
    }

    @Override
    public Result insertEnterprise(Enterprise enterprise) throws Exception {
        enterpriseMapper.insert(enterprise);
        //返回自动生成的id
        return Result.SUCCESS(enterprise.getId());
    }

    @Override
    public Result deleteEnterprise(int id) throws Exception {
        enterpriseMapper.deleteById(id);
        return Result.SUCCESS();
    }
}
