package com.xwwwww.purchaseplatform.controller.data;

import com.xwwwww.purchaseplatform.entity.administration.administrator.Shopkeeper;
import com.xwwwww.purchaseplatform.entity.shopping.shop.Shop;
import com.xwwwww.purchaseplatform.service.data.ShopService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="店铺模块")
@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class ShopController {
    @Autowired
    ShopService shopService;

    @ApiOperation(value="根据id获取数据")
    @ResponseBody
    @GetMapping("/shop")
    public Result getShopById(int id) throws Exception {
       return shopService.getShopById(id);
    }

    @ApiOperation(value="根据店铺名称获取数据")
    @ResponseBody
    @GetMapping("/shop/name")
    public Result getShopByName(String name) throws Exception{
       return shopService.getShopByName(name);
    }

    @ApiOperation(value="添加数据")
    @ResponseBody
    @PostMapping("/shop")
    public Result insertShop(@RequestBody Shop shop) throws Exception{
        return shopService.insertShop(shop);
    }

    @ApiOperation(value="删除数据")
    @ResponseBody
    @DeleteMapping("/shop")
    public Result deleteShop(int id) throws Exception{
        return shopService.deleteShop(id);
    }

    @ApiOperation(value="根据店铺名称获取数据")
    @ResponseBody
    @PutMapping("/shop")
    public Result updateShop(@RequestBody Shop shop) throws  Exception{
        return shopService.updateShop(shop);
    }

    @ApiOperation(value="根据店铺名称获取数据")
    @ResponseBody
    @GetMapping("/shop/all")
    public Result getAllShops() throws Exception{
        return shopService.getAllShops();
    }

    @ApiOperation(value="根据店主id获取数据")
    @ResponseBody
    @GetMapping("/shop/shopKeeperId")
    public Result getShopByShopKeeper(@RequestBody Shopkeeper shopkeeper) throws Exception{
        return shopService.getShopByShpShopKeeper(shopkeeper);
    }
}
