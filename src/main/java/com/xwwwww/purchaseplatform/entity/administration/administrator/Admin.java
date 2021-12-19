package com.xwwwww.purchaseplatform.entity.administration.administrator;

import lombok.Data;

@Data
public class Admin {
    int id;

    String userName;

    String password;

    //1代表平台管理员 2代表店铺管理员 3代表企业管理员
    int flag;
}
