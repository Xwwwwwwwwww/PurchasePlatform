package com.xwwwww.purchaseplatform.entity.administration.administrator;
import lombok.Data;
@Data
public class Shopkeeper {
    // id
    private int id;

    // 用户名
    private String userName;

    // 密码
    private String password;

    // 认证等级
    private  int authorizationLevel;

    // 店铺id
    private int shopid;
}
