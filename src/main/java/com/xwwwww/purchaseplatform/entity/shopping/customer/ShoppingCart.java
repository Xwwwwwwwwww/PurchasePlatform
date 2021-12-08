package com.xwwwww.purchaseplatform.entity.shopping.customer;
import lombok.Data;

@Data
public class ShoppingCart {
    // id
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
