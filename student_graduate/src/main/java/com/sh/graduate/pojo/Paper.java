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
@Table(name="tb_paper")
public class Paper implements Serializable{

	@Id
	private String id;//学生ID


	
	private String paperUrl;//论文地址
	private String hasScore;//评分状态
	private String paperGrade;//论文分数
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

	public String getPaperUrl() {		
		return paperUrl;
	}
	public void setPaperUrl(String paperUrl) {
		this.paperUrl = paperUrl;
	}

	public String getHasScore() {		
		return hasScore;
	}
	public void setHasScore(String hasScore) {
		this.hasScore = hasScore;
	}

	public String getPaperGrade() {		
		return paperGrade;
	}
	public void setPaperGrade(String paperGrade) {
		this.paperGrade = paperGrade;
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
