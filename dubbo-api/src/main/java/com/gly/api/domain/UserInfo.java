package com.gly.api.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserInfo implements Serializable {
    private String name;
    private String phone;
    private Integer age;
    private String address;
    private String traceId;
}
