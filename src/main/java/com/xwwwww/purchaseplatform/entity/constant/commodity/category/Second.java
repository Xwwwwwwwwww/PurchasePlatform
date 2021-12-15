package com.xwwwww.purchaseplatform.entity.constant.commodity.category;

import lombok.Data;

import java.util.List;

@Data
public class Second {
    //第二级的编号
    private int secondId;

    // 下属的第三级的列表
    private List<ThirdCategory> ThirdCategoryList;
}
