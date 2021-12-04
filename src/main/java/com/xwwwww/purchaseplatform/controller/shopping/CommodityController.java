package com.xwwwww.purchaseplatform.controller.shopping;

import com.xwwwww.purchaseplatform.entity.shopping.commodity.Commodity;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Search;
import com.xwwwww.purchaseplatform.mapper.shopping.commodity.CommodityMapper;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping")
public class CommodityController {
    @Autowired
    CommodityMapper commodityMapper;

    @ResponseBody
    @GetMapping("/commodity")
    public Commodity getCommodityByid(int id) throws Exception{
        return commodityMapper.getById(id);
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
}

