package com.xwwwww.purchaseplatform.service.enterprise;

import com.xwwwww.purchaseplatform.entity.administration.enterprise.Enterprise;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EnterpriseService {

    public List<Enterprise> getAllEnterprise();
    public int deleteEnterpriseById(int id);
}
