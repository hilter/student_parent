package com.sh.graduate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sh.graduate.pojo.Teacher;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface TeacherDao extends JpaRepository<Teacher,String>,JpaSpecificationExecutor<Teacher>{
	
}
