package com.xwwwww.purchaseplatform.entity.shopping.order;
import lombok.Data;
@Data
public class Order {
    //账号id
    private int customerid;

    //商品id
    private int commodityid;

    //数量
    private int quantity;

    //尺寸类
    private int sizeSystem;

    //尺寸
    private int size;

    //订单状态
    private int orderStatus;

    //逻辑编号
    private String logisticsNumber;

    // 价格
    private double price;

    //折扣
    private int discount;

    //货运
    private double freight;

    //评论
    private String remarks;

    //快递公司
    private int expressCompany;
}
