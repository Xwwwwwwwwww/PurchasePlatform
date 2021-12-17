package com.xwwwww.purchaseplatform.controller.shopping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Search;
import com.xwwwww.purchaseplatform.mapper.shopping.commodity.CommodityMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class CommodityController {
    @Autowired
    CommodityMapper commodityMapper;

    @ResponseBody
    @GetMapping("/commodity/id")
    public Commodity getCommodityByid(int id) throws Exception{
        return commodityMapper.getById(id);
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
    public List<Commodity> getCommodityByName(String name) throws Exception{
        QueryWrapper<Commodity> queryWrapper=new QueryWrapper<>();
        //模糊查询：%value%
        queryWrapper.like("name",name);
        return commodityMapper.selectList(queryWrapper);
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
    public List<Commodity> getCommodityByShop(String name) throws Exception{
        QueryWrapper<Commodity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",name);
        return commodityMapper.selectList(queryWrapper);
    }

    @ResponseBody
    @PostMapping("/commodity")
    public int insertCommodity(Commodity commodity) throws Exception{
        return commodityMapper.insert(commodity);
    }

    @ResponseBody
    @DeleteMapping("/commodity")
    public int deleteCommodityByid(int id) throws Exception{
        return commodityMapper.deleteById((id));
    }

    @ResponseBody
    @PutMapping("/commodity")
    public int updateCommodity(Commodity commodity) throws  Exception{
        return commodityMapper.updateById(commodity);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有商品
     */
    @ResponseBody
    @GetMapping("/commodity/all")
    public List<Commodity> getAllCommodity() throws Exception{
        return commodityMapper.selectList(null);
    }
}

