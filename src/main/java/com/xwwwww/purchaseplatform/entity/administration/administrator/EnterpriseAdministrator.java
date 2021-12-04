package com.xwwwww.purchaseplatform.entity.administration.administrator;
import lombok.Data;
@Data
public class EnterpriseAdministrator {

    //id
    private int id;

    //用户名
    private String userName;

    //密码
    private String password;

    //所属企业id
    private int belongingEnterprise;
}
