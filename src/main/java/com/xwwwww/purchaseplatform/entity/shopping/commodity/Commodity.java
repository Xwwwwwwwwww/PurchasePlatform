package com.xwwwww.purchaseplatform.entity.shopping.commodity;
import lombok.Data;

@Data
public class Commodity {
private int id;
private String name;
private String belongingShopName;
private int belongingShop;
private double price;
private int discount;
private int sizeSystem;
private int stock;
private String thumbnailURL;
private String rotationURL;
private int rotationNumber;
private String detailsURL;
private int detailsNumber;
private String introduce;
private int firstCategory;
private int secondCategory;
private int thirdCategory;
private int firstSpecificationSelection;
private String firstSpecificationValue;
private int secondSpecificationSelection;
private String secondSpecificationValue;
private int releaseStatus;
private int ifRecommend;
}
