package com.xwwwww.purchaseplatform.entity.administration.administrator;
import lombok.Data;
@Data
public class EnterpriseAdministrator {
    private int id;
    private String userName;
    private String password;
    private int belongingEnterprise;
}
