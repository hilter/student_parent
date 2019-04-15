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
@Table(name="tb_system_user")
public class SystemUser implements Serializable{

	@Id
	private String id;//ID


	
	private String userName;//用户账号
	private String password;//用户密码
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

	public String getRamark() {		
		return ramark;
	}
	public void setRamark(String ramark) {
		this.ramark = ramark;
	}


	
}
