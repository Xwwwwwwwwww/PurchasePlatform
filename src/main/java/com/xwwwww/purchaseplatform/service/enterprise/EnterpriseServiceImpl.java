package com.xwwwww.purchaseplatform.service.enterprise;

import com.xwwwww.purchaseplatform.entity.administration.enterprise.Enterprise;
import com.xwwwww.purchaseplatform.mapper.administration.enterprise.EnterpriseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceImpl {
@Autowired
EnterpriseMapper enterpriseMapper;
    /**
     *
     * @return list
     * @throws Exception
     * 查询所有企业信息
     */
    public List<Enterprise> getAllCustomers() throws Exception{
        return enterpriseMapper.getAllEnterprise();
    }

    public int deleteEnterpriseById( int id) throws Exception{
        return enterpriseMapper.deleteEnterpriseById(id);

    }
}
