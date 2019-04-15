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
@Table(name="tb_student")
public class Student implements Serializable{

	@Id
	private String id;//学生ID


	
	private String userName;//用户账号
	private String password;//用户密码
	private String collegeId;//所属学院ID
	private String classId;//所属班级ID
	private String tutorId;//导师ID
	private String studentTel;//联系方式
	private String student_email;//邮箱
	private String sex;//性别
	private String paperId;//论文ID
	private String uploadStatus;//论文上传状态
	private java.util.Date createTime;//创建日期
	private java.util.Date updateTime;//修改日期
	private String status;//在校状态
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

	public String getClassId() {		
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getTutorId() {		
		return tutorId;
	}
	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}

	public String getStudentTel() {		
		return studentTel;
	}
	public void setStudentTel(String studentTel) {
		this.studentTel = studentTel;
	}

	public String getStudent_email() {		
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getSex() {		
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPaperId() {		
		return paperId;
	}
	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getUploadStatus() {		
		return uploadStatus;
	}
	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
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
