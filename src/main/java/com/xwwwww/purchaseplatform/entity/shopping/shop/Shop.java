package com.xwwwww.purchaseplatform.entity.shopping.shop;
import lombok.Data;

@Data
public class Shop {

    // id
    private int id;

    // 名称
    private String name;

    //店主id
    private int shopkeeperId;

    //企业从属
    private int belongingEnterprise;

    //收藏
    private int star;

    //发货地址
    private String shopAddress;

    private String titlePictureUrl;
}
