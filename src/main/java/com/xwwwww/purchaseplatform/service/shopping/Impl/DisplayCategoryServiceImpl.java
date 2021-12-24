package com.xwwwww.purchaseplatform.service.shopping.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.constant.commodity.category.FirstCategory;
import com.xwwwww.purchaseplatform.entity.constant.commodity.category.Second;
import com.xwwwww.purchaseplatform.entity.constant.commodity.category.SecondCategory;
import com.xwwwww.purchaseplatform.entity.constant.commodity.category.ThirdCategory;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.category.FirstCategoryMapper;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.category.SecondCategoryMapper;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.category.ThirdCategoryMapper;
import com.xwwwww.purchaseplatform.service.shopping.DisplayCategoryService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisplayCategoryServiceImpl implements DisplayCategoryService {
    @Autowired
    FirstCategoryMapper firstCategoryMapper;

    @Autowired
    SecondCategoryMapper secondCategoryMapper;

    @Autowired
    ThirdCategoryMapper thirdCategoryMapper;

    @Override
    public Result DisplayFirst() {
        List<FirstCategory> firstCategoryList=firstCategoryMapper.selectList(null);
        return Result.SUCCESS(firstCategoryList);
    }

    @Override
    public Result DisplaySingle(int firstId) {
        List<Second> secondList = new ArrayList<>();
        QueryWrapper<SecondCategory> secondCategoryQueryWrapper = new QueryWrapper<>();
        secondCategoryQueryWrapper.eq("belonging_Category", firstId);
        List<SecondCategory> secondCategoryList = secondCategoryMapper.selectList(secondCategoryQueryWrapper);
        for (SecondCategory secondCategory : secondCategoryList) {
            Second second = new Second();
            int secondId = secondCategory.getId();
            QueryWrapper<ThirdCategory> thirdCategoryQueryWrapper = new QueryWrapper<>();
            thirdCategoryQueryWrapper.eq("belonging_Category", secondId);
            List<ThirdCategory> thirdCategoryList = thirdCategoryMapper.selectList(thirdCategoryQueryWrapper);
            second.setSecondId(secondCategory.getId());
            second.setCategoryName(secondCategory.getCategoryName());
            second.setThirdCategoryList(thirdCategoryList);
            secondList.add(second);
        }
        return Result.SUCCESS(secondList);
    }
}
