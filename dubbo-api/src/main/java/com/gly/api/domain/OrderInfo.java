package com.gly.api.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class OrderInfo implements Serializable {
    private String orderNo;
    private BigDecimal orderPrice;
    private String remark;
    private String creator;
    private Timestamp orderTime;
}
