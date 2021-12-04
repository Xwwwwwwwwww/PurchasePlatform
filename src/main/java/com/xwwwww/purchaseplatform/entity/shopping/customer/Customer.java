package com.xwwwww.purchaseplatform.entity.shopping.customer;

import lombok.Data;

@Data
public class Customer {

    //id
    private int id;

    //昵称
    private String nickName;

    //头像url
    private String avatarURL;

    //餐卡余额
    private  double cardBalance;

    //身份（员工/普通用户）
    private  int identity;

    //手机号
    private  String phoneNumber;

    //密码
    private  String password;

    //所属企业id
    private  int belongingEnterprise;

    //帐号状态
    private int customerStatus;
}
