package com.xwwwww.purchaseplatform.entity.constant.commodity.category;
import lombok.Data;

import java.util.List;

@Data
public class SecondCategory {
    // id
    private int id;

    // 分类名
    private String categoryName;

    // 分类从属
    private int belongingCategory;
}
