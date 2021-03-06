package com.xwwwww.purchaseplatform.entity.shopping.customer;

import lombok.Data;

@Data
public class ShoppingCartDisplay {
    private int id;

    private int customerId;

    private int commodityId;

    private double commodityPrice;

    //new
    private String commodityName;

    //new
    private String commodityUrl;

    //new
    private String shopName;

    private int shopId;

    private int sizeSystem;

    //new 具体值
    private String size;

    private int sizeId;

    private int quantity;

    private int stock;
}
