package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 成绩表
 *
 * @author liudw liudw@weds.com.cn
 * @since 1.0.0 2019-12-26
 */
@Data
public class EduScoreDTO{

	private Long id;

	private Long exam_id;

	private String realname;

	private String userNo;

	private String testNo;

	private Long gradeId;

	private Long classId;

	private String className;

	private Float totalDefaultScore;

	private Integer subjectCount;

	private Integer classPersonCount;

	private Integer gradePersonCount;

	private Float totalScore;

	private Float totalClassAvgScore;

	private Float totalClassMaxScore;

	private Integer totalClassRank;

	private Float totalGradeAvgScore;

	private Float totalGradeMaxScore;

	private Integer totalGradeRank;


	private Date importDate;

	private Integer schoolId;

	private Integer isDeleted;

	private Long createUser;

	private Date createDate;

	private Long updateUser;

	private Date updateDate;

	private Integer version;

	List<EduScoreItemDTO> score_items = new ArrayList<>();


	private String schoolTerm;

	private String exam_name;

	private Date examStartDate;

	private int size;


}
