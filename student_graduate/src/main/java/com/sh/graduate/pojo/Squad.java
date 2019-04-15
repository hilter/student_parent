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
@Table(name="tb_squad")
public class Squad implements Serializable{

	@Id
	private String id;//班级ID


	
	private String collegeId;//所属学院ID
	private String name;//班级名称
	private String leader;//辅导员
	private String leaderTel;//辅导员联系方式
	private String leaderEmail;//辅导员邮箱
	private String desc;//班级介绍
	private java.util.Date createTime;//创建日期
	private java.util.Date updateTime;//修改日期
	private String status;//状态
	private String ramark;//备注

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCollegeId() {		
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLeader() {		
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getLeaderTel() {		
		return leaderTel;
	}
	public void setLeaderTel(String leaderTel) {
		this.leaderTel = leaderTel;
	}

	public String getLeaderEmail() {		
		return leaderEmail;
	}
	public void setLeaderEmail(String leaderEmail) {
		this.leaderEmail = leaderEmail;
	}

	public String getDesc() {		
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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

	public String getRamark() {		
		return ramark;
	}
	public void setRamark(String ramark) {
		this.ramark = ramark;
	}


	
}
