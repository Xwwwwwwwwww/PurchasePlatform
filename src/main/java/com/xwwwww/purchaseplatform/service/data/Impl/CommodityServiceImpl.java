package com.xwwwww.purchaseplatform.service.data.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.mapper.shopping.commodity.CommodityMapper;
import com.xwwwww.purchaseplatform.service.data.CommodityService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    CommodityMapper commodityMapper;

    @Override
    public Result getCommodityById(int id) throws Exception {
        Commodity commodity=commodityMapper.getById(id);
        return Result.SUCCESS(commodity);
    }

    @Override
    public Result getCommodityByName(String name) throws Exception {
        QueryWrapper<Commodity> queryWrapper=new QueryWrapper<>();
        System.out.println(name);
        //模糊查询：%value%
        queryWrapper.like("name",name);
        List<Commodity> commodityList=commodityMapper.selectList(queryWrapper);
        return Result.SUCCESS(commodityList);
    }

    @Override
    public Result insertCommodity(Commodity commodity) throws Exception {
        return Result.SUCCESS(commodityMapper.insert(commodity));
    }

    @Override
    public Result deleteCommodityById(int id) throws Exception {
        return Result.SUCCESS(commodityMapper.deleteById((id)));
    }

    @Override
    public Result updateCommodity(Commodity commodity) throws Exception {
        return Result.SUCCESS(commodityMapper.updateById(commodity));
    }

    @Override
    public Result getAllCommodity() throws Exception {
        return Result.SUCCESS(commodityMapper.selectList(null));
    }

    @Override
    public Result getRecommendedCommodity() throws Exception {
        QueryWrapper<Commodity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("if_Recommend",1);
        List<Commodity> commodityList=commodityMapper.selectList(queryWrapper);
        return Result.SUCCESS(commodityList);
    }

    @Override
    public Result getRecommendedCommodity(int shopId) throws Exception {
        QueryWrapper<Commodity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("belonging_Shop",shopId);
        List<Commodity> commodityList=commodityMapper.selectList(queryWrapper);

        List<Commodity> resultList=new ArrayList<>();
        for (Commodity commodity : commodityList) {
            if (commodity.getIfRecommend()==1)
                resultList.add(commodity);
        }
        return Result.SUCCESS(resultList);
    }

    @Override
    public Result getNotRecommendedCommodityByShop(int shopId) throws Exception {
        QueryWrapper<Commodity> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("belonging_Shop",shopId);
        List<Commodity> commodityList=commodityMapper.selectList(queryWrapper1);

        List<Commodity> resultList=new ArrayList<>();
        for (Commodity commodity : commodityList) {
            if (commodity.getIfRecommend()==0)
                resultList.add(commodity);
        }
        return Result.SUCCESS(resultList);
    }

    @Override
    public Result getCommodityByShop(String name) throws Exception {
        QueryWrapper<Commodity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("belonging_Shop_Name",name);
        List<Commodity> commodityList=commodityMapper.selectList(queryWrapper);
        return Result.SUCCESS(commodityList);
    }

    @Override
    public Result getCommodityByShop(int shopId) throws Exception {
        QueryWrapper<Commodity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("belonging_Shop",shopId);
        List<Commodity> commodityList=commodityMapper.selectList(queryWrapper);
        return Result.SUCCESS(commodityList);
    }

    @Override
    public Result getCommodityByThird(int third) throws Exception {
        QueryWrapper<Commodity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("third_category",third);
        List<Commodity> commodityList=commodityMapper.selectList(queryWrapper);
        return Result.SUCCESS(commodityList);
    }
}
