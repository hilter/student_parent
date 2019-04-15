package com.sh.graduate.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_teacher")
public class Teacher implements Serializable{

	@Id
	private String id;//教师ID


	
	private String userName;//用户账号
	private String password;//用户密码
	private String collegeId;//所属学院ID
	private String academic;//学历
	private String schoolGraduation;//毕业院校
	private String teacherTel;//联系方式
	private String teacherEmail;//邮箱
	private String sex;//性别
	private java.util.Date createTime;//创建日期
	private java.util.Date updateTime;//修改日期
	private String status;//在校状态
	private String desc;//教师介绍
	private String isDelete;//是否删除
	private String ramark;//备注

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {		
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {		
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getCollegeId() {		
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getAcademic() {		
		return academic;
	}
	public void setAcademic(String academic) {
		this.academic = academic;
	}

	public String getSchoolGraduation() {		
		return schoolGraduation;
	}
	public void setSchoolGraduation(String schoolGraduation) {
		this.schoolGraduation = schoolGraduation;
	}

	public String getTeacherTel() {		
		return teacherTel;
	}
	public void setTeacherTel(String teacherTel) {
		this.teacherTel = teacherTel;
	}

	public String getTeacherEmail() {		
		return teacherEmail;
	}
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getSex() {		
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public java.util.Date getCreateTime() {		
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getUpdateTime() {		
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getStatus() {		
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getDesc() {		
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getIsDelete() {		
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getRamark() {		
		return ramark;
	}
	public void setRamark(String ramark) {
		this.ramark = ramark;
	}


	
}
