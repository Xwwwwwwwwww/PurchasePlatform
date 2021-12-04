package com.xwwwww.purchaseplatform.entity.shopping.evaluate;
import lombok.Data;

import java.sql.Blob;

@Data
public class Evaluate {

    private int id;

    private int commodityid;

    private int orderid;

    private Blob content;

    private String firstPicture;

    private String secondPicture;

    private String thirdPicture;


}
