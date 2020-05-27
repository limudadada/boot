package com.example.socket;

import lombok.Data;

@Data
public class PartnerInfoDto {

    private Integer parentId;

    private String parentTel;

    private String parentName;

    // 家长状态 1：家长未登记手机号。2：家长未登录校园足迹。3：家长未关注校园足迹公众号。0：家长注册成功
    private Integer parentState;
}
