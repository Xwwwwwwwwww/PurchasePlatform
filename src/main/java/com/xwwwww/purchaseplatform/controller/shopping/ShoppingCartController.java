package com.xwwwww.purchaseplatform.controller.shopping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCart;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ShoppingCartController {
    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    /**
     *
     * @param customer_id
     * @return List<ShoppingCart>
     * @throws Exception
     * 查询某顾客买了什么东西，使用selectList方法
     */
    @ResponseBody
    @GetMapping("/shoppingCart/customer")
    public List<ShoppingCart> getShoppingCartByCustomerId(int customer_id) throws Exception{
        QueryWrapper<ShoppingCart> shoppingCartQueryWrapper=new QueryWrapper<>();
        shoppingCartQueryWrapper.eq("customer_id",customer_id);
        return shoppingCartMapper.selectList(shoppingCartQueryWrapper);
    }

    /**
     *
     * @param commodity_id
     * @return list
     * @throws Exception
     * 查询某个商品被哪些用户买了
     */
    @ResponseBody
    @GetMapping("/shoppingCart/commodity")
    public List<ShoppingCart> getShoppingCartByCommodityId(int commodity_id) throws Exception{
        QueryWrapper<ShoppingCart> shoppingCartQueryWrapper=new QueryWrapper<>();
        shoppingCartQueryWrapper.eq("commodity_id",commodity_id);
        return shoppingCartMapper.selectList(shoppingCartQueryWrapper);
    }


    @ResponseBody
    @PostMapping("/shoppingCart")
    public int insertShoppingCart(ShoppingCart shoppingCart) throws Exception{
        return shoppingCartMapper.insert(shoppingCart);
    }

    @ResponseBody
    @DeleteMapping("/shoppingCart")
    public int deleteShoppingCart(int id) throws Exception{
        return shoppingCartMapper.deleteById((id));
    }

    @ResponseBody
    @PutMapping("/shoppingCart")
    public int updateShoppingCart(ShoppingCart shoppingCart) throws  Exception{
        return shoppingCartMapper.updateById(shoppingCart);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有购物车
     */
    @ResponseBody
    @GetMapping("/shoppingCart/all")
    public List<ShoppingCart> getAllShoppingCarts() throws Exception{
        return shoppingCartMapper.selectList(null);
    }


}
