package com.xwwwww.purchaseplatform.controller.shopping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.customer.DeliveryAddress;
import com.xwwwww.purchaseplatform.entity.shopping.customer.ShoppingCart;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.DeliveryAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class DeliveryAddressController {
    @Autowired
    DeliveryAddressMapper deliveryAddressMapper;

    @ResponseBody
    @PostMapping("/deliveryAddress")
    public int insertDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception{
        return deliveryAddressMapper.insert(deliveryAddress);
    }

    @ResponseBody
    @DeleteMapping("/deliveryAddress")
    public int deleteDeliveryAddress(int id) throws Exception{
        return deliveryAddressMapper.deleteById((id));
    }

    @ResponseBody
    @PutMapping("/deliveryAddress")
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) throws  Exception{
        return deliveryAddressMapper.updateById(deliveryAddress);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有地址
     */
    @ResponseBody
    @GetMapping("/deliveryAddress/all")
    public List<DeliveryAddress> getAllDeliveryAddress() throws Exception{
        return deliveryAddressMapper.selectList(null);
    }

    /**
     *
     * @param customer_id
     * @return list
     * @throws Exception
     * 查询某位顾客的所有地址
     */
    @ResponseBody
    @GetMapping("/deliveryAddress/customer")
    public List<DeliveryAddress> getDeliveryAddressByCustomerId(int customer_id) throws Exception{
        QueryWrapper<DeliveryAddress> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("customer_id",customer_id);
        return deliveryAddressMapper.selectList(queryWrapper);
    }
}
