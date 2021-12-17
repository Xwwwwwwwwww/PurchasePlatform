package com.xwwwww.purchaseplatform.entity.shopping.order;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("orders")
public class Orders {
    //id，自增
    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    //账号id
    private int customerId;

    //商品id
    private int commodityId;

    //数量
    private int quantity;

    //尺寸类
    private int sizeSystem;

    //尺寸
    private int size;

    //订单状态
    private int orderStatus;

    //逻辑编号
    private String logisticsNumber;

    // 价格
    private double price;

    //折扣
    private int discount;

    //货运
    private double freight;

    //评论
    private String remarks;

    //快递公司
    private int expressCompany;

    private String thumbnailUrl;

    // 商店名
    private String belongingShopName;

    //商店从属
    private int belongingShop;

    private String sizeName;

    private String commodityName;
}
