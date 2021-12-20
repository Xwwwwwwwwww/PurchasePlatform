package com.xwwwww.purchaseplatform.entity.shopping.customer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("shopping_collection")
public class ShoppingCollection {
    // id
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    //顾客id
    private int customerId;

    //商品id
    private int commodityId;
}
