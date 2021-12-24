package com.xwwwww.purchaseplatform.controller.shopping;

import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCart;
import com.xwwwww.purchaseplatform.service.data.ShoppingCartService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     *
     * @param customerId
     * @return List<ShoppingCart>
     * @throws Exception
     * 查询某顾客买了什么东西，使用selectList方法
     */
    @ResponseBody
    @GetMapping("/shoppingCart/customer")
    public Result getShoppingCartByCustomerId(int customerId) throws Exception{
        return shoppingCartService.getShoppingCartByCustomerId(customerId);
    }

    /**
     *
     * @param commodityId
     * @return list
     * @throws Exception
     * 查询某个商品被哪些用户买了
     */
    @ResponseBody
    @GetMapping("/shoppingCart/commodity")
    public Result getShoppingCartByCommodityId(int commodityId) throws Exception{
       return shoppingCartService.getShoppingCartByCommodityId(commodityId);
    }

    /**
     *
     * @param shoppingCart
     * @return
     * @throws Exception
     * 购物车添加商品
     */
    @ResponseBody
    @PostMapping("/shoppingCart")
    public Result insertShoppingCart(@RequestBody ShoppingCart shoppingCart) throws Exception{
        return shoppingCartService.insertShoppingCart(shoppingCart);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     * 删除购物车
     */
    @ResponseBody
    @DeleteMapping("/shoppingCart")
    public Result deleteShoppingCart(int id) throws Exception{
        return shoppingCartService.deleteShoppingCart(id);
    }

    /**
     *
     * @param shoppingCart
     * @return
     * @throws Exception
     * 更新购物车
     */
    @ResponseBody
    @PutMapping("/shoppingCart")
    public Result updateShoppingCart(ShoppingCart shoppingCart) throws  Exception{
        return shoppingCartService.updateShoppingCart(shoppingCart);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有购物车
     */
    @ResponseBody
    @GetMapping("/shoppingCart/all")
    public Result getAllShoppingCarts() throws Exception{
        return shoppingCartService.getAllShoppingCarts();
    }

    /**
     *
     * @param shoppingCart
     * @return
     * @throws Exception
     * 根据商品id和顾客id判断是否在购物车内
     */
    @ResponseBody
    @GetMapping("/shoppingCart/in")
    public Result inShoppingCart(ShoppingCart shoppingCart) throws Exception{
        return shoppingCartService.inShoppingCart(shoppingCart);
    }
}
