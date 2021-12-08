package com.xwwwww.purchaseplatform.entity.shopping.customer;
import lombok.Data;

@Data
public class Search {
    //id
    private int id;

    //买家id
    private int customerId;

    //内容
    private String content;
}
