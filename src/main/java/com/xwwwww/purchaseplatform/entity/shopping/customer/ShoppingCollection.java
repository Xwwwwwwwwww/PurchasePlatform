package com.xwwwww.purchaseplatform.entity.shopping.customer;

import lombok.Data;

@Data
public class ShoppingCollection {
    // id
    private int id;

    //顾客id
    private int customerId;

    //商品id
    private int commodityId;
}
