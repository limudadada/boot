package com.example.socket;

import lombok.Data;

import java.util.List;

@Data
public class StudentParentInfoRespDto {

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

    private String facePic;

    private Short isBandingApp;

    private Integer isGrade;

    private List<PartnerInfoDto> partnerInfoDtoList;

}
