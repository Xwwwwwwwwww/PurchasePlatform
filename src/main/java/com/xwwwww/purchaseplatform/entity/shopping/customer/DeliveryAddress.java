package com.xwwwww.purchaseplatform.entity.shopping.customer;
import lombok.Data;

@Data
public class DeliveryAddress {
     // id
     private int id;

     //买家id
     private int customerid;

     //收货地址
     private String deliveryaddress;

}
