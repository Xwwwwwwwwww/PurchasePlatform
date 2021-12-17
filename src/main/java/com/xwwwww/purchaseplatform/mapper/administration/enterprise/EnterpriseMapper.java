package com.xwwwww.purchaseplatform.mapper.administration.enterprise;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xwwwww.purchaseplatform.entity.administration.enterprise.Enterprise;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnterpriseMapper extends BaseMapper<Enterprise> {
    public List<Enterprise> getAllEnterprise();
    public int deleteEnterpriseById(int id);
}
