package com.example.socket;

import lombok.Data;

@Data
public class StudentParentInfoResp {

    private Integer studentId;

    private String studentName;

    private String userDep;

    private String userNo;

    private String userTel;

    private String userIdentity;

    private String userEmail;

    private Integer userSex;

    private String nodePathName;

    private String ptNodePathName;

    private String deptName;

    private String userPhoto;

    private Integer schoolId;

    private String appHeadPhoto;

    private String verifyPassword;

    private Integer parentId;

    private String parentTel;

    private String parentName;

    private String facePic;

    private Short isBandingApp;

    private Integer isGrade;

    // 家长状态 1：家长未登记手机号。2：家长未登录校园足迹。3：家长未关注校园足迹公众号。0：家长注册成功
    private Integer parentState;

}
