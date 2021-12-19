package com.xwwwww.purchaseplatform.entity.shopping.customer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("customer")
public class Customer {

    //id
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    //昵称
    private String nickName;

    //头像url
    //这里不要写成URL，否则会变得不幸 ---lgr
    private String avatarUrl;

    //餐卡余额
    private  double cardBalance;

    //身份（员工/普通用户）
    private  int identity;

    //手机号
    private  String phoneNumber;

    //密码
    private  String password;

    //从属企业id
    private  int belongingEnterprise;

    //帐号状态
    private int customerStatus;
}
