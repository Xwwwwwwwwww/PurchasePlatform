package com.xwwwww.purchaseplatform.entity.shopping.customer;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("shopping_cart")
public class ShoppingCart {
    // id
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    //顾客id
    private int customerId;

    //商品id
    private int commodityId;

    //数量
    private int quantity;

    //类型从属
    private int sizeSystem;

    //类型
    private int size;
}
