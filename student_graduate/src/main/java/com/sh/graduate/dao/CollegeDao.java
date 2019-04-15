package com.sh.graduate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sh.graduate.pojo.College;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface CollegeDao extends JpaRepository<College,String>,JpaSpecificationExecutor<College>{
	
}
