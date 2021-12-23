package com.xwwwww.purchaseplatform.entity.constant.order;

import lombok.Data;

@Data
public class OrderStatusNumber {
    int toBePaid;

    int toBeSent;

    int toBeReceived;

    int toBeEvaluated;

    int afterSale;
}
