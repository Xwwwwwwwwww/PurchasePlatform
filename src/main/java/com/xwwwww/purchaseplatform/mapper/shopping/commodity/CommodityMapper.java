package com.xwwwww.purchaseplatform.mapper.shopping.commodity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {
    public Commodity getById(int id);
}
