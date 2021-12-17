package com.xwwwww.purchaseplatform.entity.administration.enterprise;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("enterprise")
@Data
public class Enterprise {
    // id
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    // 企业名称
    private String name;
}
