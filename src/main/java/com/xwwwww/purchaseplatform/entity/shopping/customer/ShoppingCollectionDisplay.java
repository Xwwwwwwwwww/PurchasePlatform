package com.xwwwww.purchaseplatform.entity.shopping.customer;

import lombok.Data;

@Data
public class ShoppingCollectionDisplay {
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

    private int stock;
}
