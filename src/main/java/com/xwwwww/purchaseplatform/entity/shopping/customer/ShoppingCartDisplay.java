package com.xwwwww.purchaseplatform.entity.shopping.customer;

import lombok.Data;

@Data
public class ShoppingCartDisplay {
    private int customerId;

    private int commodityId;

    //new
    private String commodityName;

    //new
    private String commodityUrl;

    //new
    private String shopName;

    private int sizeSystem;

    private int size;

    private int quantity;
}
