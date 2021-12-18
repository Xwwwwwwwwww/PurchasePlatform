package com.xwwwww.purchaseplatform.controller.shopping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Search;
import com.xwwwww.purchaseplatform.mapper.shopping.commodity.CommodityMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.SearchMapper;
import com.xwwwww.purchaseplatform.service.data.CommodityService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class CommodityController {
    @Autowired
    CommodityService commodityService;

    @ResponseBody
    @GetMapping("/commodity/id")
    public Result getCommodityById(int id) throws Exception{
        return commodityService.getCommodityById(id);
    }

    /**
     *
     * @param name
     * @return list
     * @throws Exception
     * 在网站的搜索栏中输入商品的关键字
     */
    @ResponseBody
    @GetMapping("/commodity/name")
    public Result getCommodityByName(String name) throws Exception{
        QueryWrapper<Commodity> queryWrapper=new QueryWrapper<>();
        //模糊查询：%value%
        queryWrapper.like("name",name);
        return commodityService.getCommodityByName(name);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     * 根据店铺名查询商品
     */
    @ResponseBody
    @GetMapping("/commodity/shop")
    public Result getCommodityByShop(String name) throws Exception{
        return commodityService.getCommodityByShop(name);
    }

    @ResponseBody
    @PostMapping("/commodity")
    public Result insertCommodity(Commodity commodity) throws Exception{
        return commodityService.insertCommodity(commodity);
    }

    @ResponseBody
    @DeleteMapping("/commodity")
    public Result deleteCommodityById(int id) throws Exception{
        return commodityService.deleteCommodityById(id);
    }

    @ResponseBody
    @PutMapping("/commodity")
    public Result updateCommodity(Commodity commodity) throws  Exception{
        return commodityService.updateCommodity(commodity);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有商品
     */
    @ResponseBody
    @GetMapping("/commodity/all")
    public Result getAllCommodity() throws Exception{
        return commodityService.getAllCommodity();
    }

    /**
     *
     * @return
     * @throws Exception
     * 平台管理员：查询所有推荐商品
     */
    @ResponseBody
    @GetMapping("/commodity/recommend")
    public Result getRecommendedCommodity() throws Exception{
        return commodityService.getRecommendedCommodity();
    }

    /**
     *
     * @param shopId
     * @return
     * @throws Exception
     * 店铺管理员：查询自己店的推荐商品
     */
    @ResponseBody
    @GetMapping("/commodity/recommend/shop")
    public Result getRecommendedCommodity(int shopId) throws Exception{
        return commodityService.getRecommendedCommodity(shopId);
    }

    @ResponseBody
    @GetMapping("/commodity/notRecommend/shop")
    public Result getNotRecommendedCommodityByShop(int shopId) throws Exception{
        return commodityService.getNotRecommendedCommodityByShop(shopId);
    }

    /**
     *
     * @param shopId
     * @return
     * @throws Exception
     * 根据商铺查询商品
     */
    @ResponseBody
    @GetMapping("/commodity/shopId")
    public Result getCommodityByShop(int shopId) throws Exception{
        return commodityService.getCommodityByShop(shopId);
    }
}

