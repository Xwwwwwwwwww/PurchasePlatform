package com.xwwwww.purchaseplatform.controller.shopping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.administration.administrator.Shopkeeper;
import com.xwwwww.purchaseplatform.entity.shopping.shop.Shop;
import com.xwwwww.purchaseplatform.mapper.shopping.shop.ShopMapper;
import com.xwwwww.purchaseplatform.service.data.ShopService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class ShopController {
    @Autowired
    ShopMapper shopMapper;

    @Autowired
    ShopService shopService;

    @ResponseBody
    @GetMapping("/shop")
    public Shop getShopById(int id) throws Exception {
       return shopMapper.selectById(id);
    }

    @ResponseBody
    @GetMapping("/shop/name")
    public List<Shop> getShopByName(String name) throws Exception{
        QueryWrapper<Shop> queryWrapper=new QueryWrapper<>();
        //模糊查询：%value%
        queryWrapper.like("name",name);
        return shopMapper.selectList(queryWrapper);
    }

    @ResponseBody
    @PostMapping("/shop")
    public int insertShop(Shop shop) throws Exception{
        return shopMapper.insert(shop);
    }

    @ResponseBody
    @DeleteMapping("/shop")
    public int deleteShop(int id) throws Exception{
        return shopMapper.deleteById((id));
    }

    @ResponseBody
    @PutMapping("/shop")
    public int updateShop(Shop shop) throws  Exception{
        return shopMapper.updateById(shop);
    }

    @ResponseBody
    @GetMapping("/shop/all")
    public List<Shop> getAllShops() throws Exception{
        return shopMapper.selectList(null);
    }

    @ResponseBody
    @GetMapping("/shop/shopKeeperId")
    public Result getShopByShopKeeper(@RequestBody Shopkeeper shopkeeper) throws Exception{
        return shopService.getShopByShpShopKeeper(shopkeeper);
    }
}
