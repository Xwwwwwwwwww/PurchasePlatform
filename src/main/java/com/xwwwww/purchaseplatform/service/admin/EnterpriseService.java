package com.xwwwww.purchaseplatform.service.admin;

import com.xwwwww.purchaseplatform.entity.administration.enterprise.Enterprise;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface EnterpriseService {
    public Result getEnterpriseById(int id) throws Exception;

    public Result insertEnterprise(Enterprise enterprise) throws Exception;

    public Result deleteEnterprise(int id) throws Exception;

    public Result updateEnterprise(Enterprise enterprise) throws Exception;
}
