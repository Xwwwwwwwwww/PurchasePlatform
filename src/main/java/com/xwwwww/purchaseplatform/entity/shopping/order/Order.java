package com.xwwwww.purchaseplatform.entity.shopping.order;
import lombok.Data;
@Data
public class Order {
private int customerid;
private int commodityid;
private int quantity;
private int sizeSystem;
private int size;
private int orderStatus;
private String logisticsNumber;
private double price;
private int discount;
private double freight;
private String remarks;
private int expressCompany;
}
