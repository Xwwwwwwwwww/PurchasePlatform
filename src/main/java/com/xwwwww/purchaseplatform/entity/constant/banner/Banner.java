package com.xwwwww.purchaseplatform.entity.constant.banner;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("banner")
public class Banner {
    @TableId(value = "id", type = IdType.AUTO)
    int id;

    String name;

    String deadline;

    String describes;

    String imageUrl;
}
