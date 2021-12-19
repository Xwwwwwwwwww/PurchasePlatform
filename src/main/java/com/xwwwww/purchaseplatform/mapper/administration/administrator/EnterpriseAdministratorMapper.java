package com.xwwwww.purchaseplatform.mapper.administration.administrator;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xwwwww.purchaseplatform.entity.administration.administrator.EnterpriseAdministrator;
import com.xwwwww.purchaseplatform.entity.administration.administrator.PlatformAdministrator;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EnterpriseAdministratorMapper extends BaseMapper<EnterpriseAdministrator> {
    EnterpriseAdministrator login(EnterpriseAdministrator enterpriseAdministrator);
}
