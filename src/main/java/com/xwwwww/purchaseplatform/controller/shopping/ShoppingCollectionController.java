package com.xwwwww.purchaseplatform.controller.shopping;

import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCollection;
import com.xwwwww.purchaseplatform.service.data.ShoppingCollectionService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="收藏模块")
@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class ShoppingCollectionController {
    @Autowired
    ShoppingCollectionService shoppingCollectionService;

    @ApiOperation(value="添加数据")
    @ResponseBody
    @PostMapping("/shoppingCollection")
    public Result insertShoppingCollection(@RequestBody ShoppingCollection shoppingCollection) throws Exception{
        return shoppingCollectionService.insertShoppingCollection(shoppingCollection);
    }

    @ApiOperation(value="删除数据")
    @ResponseBody
    @DeleteMapping("/shoppingCollection")
    public Result deleteShoppingCollection(int id) throws Exception{
        return shoppingCollectionService.deleteShoppingCollection(id);
    }

    @ApiOperation(value="修改数据")
    @ResponseBody
    @PutMapping("/shoppingCollection")
    public Result updateShoppingCollection(@RequestBody ShoppingCollection shoppingCollection) throws  Exception{
        return shoppingCollectionService.updateShoppingCollection(shoppingCollection);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有收藏夹的内容
     */
    @ApiOperation(value="查询所有收藏夹的内容")
    @ResponseBody
    @GetMapping("/shoppingCollection/all")
    public Result getAllShoppingCollection() throws Exception {
        return shoppingCollectionService.getAllShoppingCollection();
    }
    /**
     *
     * @param customerId
     * @return list
     * @throws Exception
     * 查询某位顾客的收藏夹
     */
    @ApiOperation(value="查询某位顾客的收藏夹")
    @ResponseBody
    @GetMapping("/shoppingCollection/customer")
    public Result getShoppingCollectionByCustomerId(int customerId) throws  Exception{
        return shoppingCollectionService.getShoppingCollectionByCustomerId(customerId);
    }

    @ApiOperation(value="查询某位顾客收藏的商品数量")
    @ResponseBody
    @GetMapping("/shoppingCollection/itemsNumber")
    public Result getShoppingCollectionItemsNumber(int customerId) throws Exception{
        return shoppingCollectionService.getShoppingCollectionItemsNumber(customerId);
    }

    /**
     *
     * @param shoppingCollection
     * @return
     * @throws Exception
     * 这件物品是否在收藏夹里
     */
    @ApiOperation(value="查询商品是否在收藏夹里")
    @ResponseBody
    @GetMapping("/shoppingCollection/in")
    public Result inShoppingCollection(ShoppingCollection shoppingCollection) throws Exception{
        return shoppingCollectionService.inShoppingCollection(shoppingCollection);
    }
}
