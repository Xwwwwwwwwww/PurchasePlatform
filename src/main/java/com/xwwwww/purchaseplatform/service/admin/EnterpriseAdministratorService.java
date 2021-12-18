package com.xwwwww.purchaseplatform.service.admin;

import com.xwwwww.purchaseplatform.entity.administration.administrator.EnterpriseAdministrator;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface EnterpriseAdministratorService {
    Result getEnterpriseAdminById(int id) throws Exception;

    Result insertEnterpriseAdmin(EnterpriseAdministrator enterpriseAdministrator) throws Exception;

    Result deleteEnterAdmin(int id) throws Exception;

    Result updateEnterAdmin(EnterpriseAdministrator enterpriseAdministrator) throws Exception;

    Result getAllEnterpriseAdmin() throws Exception;
}
