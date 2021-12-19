package com.xwwwww.purchaseplatform.service.data;

import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CommodityService {
    public Result getCommodityById(int id) throws Exception;

    public Result getCommodityByName(String name) throws Exception;

    public Result getCommodityByShop(String name) throws Exception;

    public Result insertCommodity(Commodity commodity) throws Exception;

    public Result deleteCommodityById(int id) throws Exception;

    public Result updateCommodity(Commodity commodity) throws  Exception;

    public Result getAllCommodity() throws Exception;

    public Result getRecommendedCommodity() throws Exception;

    public Result getRecommendedCommodity(int shopId) throws Exception;

    public Result getNotRecommendedCommodityByShop(int shopId) throws Exception;

    public Result getCommodityByShop(int shopId) throws Exception;

    public Result getCommodityByThird(int third) throws Exception;
}
