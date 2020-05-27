package com.example.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 *  成绩科目表
 *
 * @author liudw liudw@weds.com.cn
 * @since 1.0.0 2019-12-26
 */
@Data
public class EduScoreItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long scoreId;

	private Long gradeId;

	private Long classId;

	private Long dicSubjectId;

	private Long classfiedSubjectId;

	private Integer subjectType;

	private String subject_name;

	private Float defaultScore;

	private Float score;

	private Float classAvgScore;

	private Float classMaxScore;

	private Integer classRank;

	private Float gradeAvgScore;

	private Float gradeMaxScore;

	private Integer gradeRank;

	private Integer schoolId;

	private Integer isDeleted;

	private Long createUser;

	private Date createDate;

	private Long updateUser;

	private Date updateDate;

	private Integer version;


}
