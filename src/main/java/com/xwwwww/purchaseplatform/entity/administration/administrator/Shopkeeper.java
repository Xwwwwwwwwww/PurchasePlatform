package com.xwwwww.purchaseplatform.entity.administration.administrator;
import lombok.Data;
@Data
public class Shopkeeper {
    private int id;
    private String userName;
    private String password;
    private  int authorizationLevel;
    private int shopid;
}
