package com.xwwwww.purchaseplatform.service.data.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.constant.commodity.size.Size;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.size.SizeMapper;
import com.xwwwww.purchaseplatform.service.data.SizeService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    SizeMapper sizeMapper;

    @Override
    public Result getSizeBySystem(int belongingSystem) throws Exception {
        QueryWrapper<Size> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("belonging_system",belongingSystem);
        List<Size> sizeList=sizeMapper.selectList(queryWrapper);
        return Result.SUCCESS(sizeList);
    }
}
