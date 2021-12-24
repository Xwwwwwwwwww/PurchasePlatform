package com.xwwwww.purchaseplatform.controller.data;

import com.xwwwww.purchaseplatform.entity.administration.administrator.Shopkeeper;
import com.xwwwww.purchaseplatform.entity.shopping.shop.Shop;
import com.xwwwww.purchaseplatform.service.data.ShopService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class ShopController {
    @Autowired
    ShopService shopService;

    @ResponseBody
    @GetMapping("/shop")
    public Result getShopById(int id) throws Exception {
       return shopService.getShopById(id);
    }

    @ResponseBody
    @GetMapping("/shop/name")
    public Result getShopByName(String name) throws Exception{
       return shopService.getShopByName(name);
    }

    @ResponseBody
    @PostMapping("/shop")
    public Result insertShop(@RequestBody Shop shop) throws Exception{
        return shopService.insertShop(shop);
    }

    @ResponseBody
    @DeleteMapping("/shop")
    public Result deleteShop(int id) throws Exception{
        return shopService.deleteShop(id);
    }

    @ResponseBody
    @PutMapping("/shop")
    public Result updateShop(@RequestBody Shop shop) throws  Exception{
        return shopService.updateShop(shop);
    }

    @ResponseBody
    @GetMapping("/shop/all")
    public Result getAllShops() throws Exception{
        return shopService.getAllShops();
    }

    @ResponseBody
    @GetMapping("/shop/shopKeeperId")
    public Result getShopByShopKeeper(@RequestBody Shopkeeper shopkeeper) throws Exception{
        return shopService.getShopByShpShopKeeper(shopkeeper);
    }
}
