package com.xwwwww.purchaseplatform.controller.shopping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCollection;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.ShoppingCollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ShoppingCollectionController {
    @Autowired
    ShoppingCollectionMapper shoppingCollectionMapper;

    @ResponseBody
    @PostMapping("/shoppingCollection")
    public int insertShoppingCollection(ShoppingCollection shoppingCollection) throws Exception{
        return shoppingCollectionMapper.insert(shoppingCollection);
    }

    @ResponseBody
    @DeleteMapping("/shoppingCollection")
    public int deleteShoppingCollection(int id) throws Exception{
        return shoppingCollectionMapper.deleteById((id));
    }

    @ResponseBody
    @PutMapping("/shoppingCollection")
    public int updateShoppingCollection(ShoppingCollection shoppingCollection) throws  Exception{
        return shoppingCollectionMapper.updateById(shoppingCollection);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有收藏夹的内容
     */
    @ResponseBody
    @GetMapping("/shoppingCollection/all")
    public List<ShoppingCollection> getAllShoppingCollection() throws Exception{
        return shoppingCollectionMapper.selectList(null);
    }

    /**
     *
     * @param customer_id
     * @return list
     * @throws Exception
     * 查询某位顾客的收藏夹
     */
    @ResponseBody
    @GetMapping("/shoppingCollection/customer")
    public List<ShoppingCollection> getShoppingCollectionByCustomerId(int customer_id) throws  Exception{
        QueryWrapper<ShoppingCollection> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("customer_id",customer_id);
        return shoppingCollectionMapper.selectList(queryWrapper);
    }
}
