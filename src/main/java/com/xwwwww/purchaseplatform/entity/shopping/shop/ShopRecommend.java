package com.xwwwww.purchaseplatform.entity.shopping.shop;
import lombok.Data;

@Data
public class ShopRecommend {
    //id
    private int id;

    // 商店号
    private int shop;

    // 推荐图链接
    private String recommendPictureURL;

    //推荐商品
    private int recommendCommodity;
}
