package com.xwwwww.purchaseplatform.entity.shopping.shop;
import lombok.Data;

@Data
public class ShopRecommend {
    private int id;
    private int shop;
    private String recommendPictureURL;
    private int recommendCommodity;
}
