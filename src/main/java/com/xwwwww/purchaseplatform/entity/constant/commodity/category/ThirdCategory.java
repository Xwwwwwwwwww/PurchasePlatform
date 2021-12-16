package com.xwwwww.purchaseplatform.entity.constant.commodity.category;
import lombok.Data;

@Data
public class ThirdCategory {
    // id
    private int id;

    // 分类名
    private String categoryName;

    //分类从属
    private int belongingCategory;

    //图片url
    private String imageUrl;
}
