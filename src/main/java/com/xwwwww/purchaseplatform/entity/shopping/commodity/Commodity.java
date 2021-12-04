package com.xwwwww.purchaseplatform.entity.shopping.commodity;
import lombok.Data;

@Data
public class Commodity {
    // id
    private int id;

    // 名称
    private String name;

    // 商店名
    private String belongingShopName;

    //商店从属
    private int belongingShop;

    //价格
    private double price;

    //折扣
    private int discount;

    //尺寸
    private int sizeSystem;

    //库存
    private int stock;

    //缩略图链接
    private String thumbnailURL;

    //轮换链接
    private String rotationURL;

    //轮换号
    private int rotationNumber;

    //详情链接
    private String detailsURL;

    //详情编号
    private int detailsNumber;

    //简介
    private String introduce;

    //第一分类
    private int firstCategory;

    //第二分类
    private int secondCategory;

    //第三分类
    private int thirdCategory;

    //第一筛选
    private int firstSpecificationSelection;

    //第二筛选
    private int secondSpecificationSelection;

    //第二筛选值
    private String secondSpecificationValue;

    //发布状态
    private int releaseStatus;

    //推荐与否
    private int ifRecommend;
}
