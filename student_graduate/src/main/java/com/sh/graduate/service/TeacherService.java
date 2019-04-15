package com.sh.graduate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sh.graduate.util.IdWorker;

import com.sh.graduate.dao.TeacherDao;
import com.sh.graduate.pojo.Teacher;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Teacher> findAll() {
		return teacherDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Teacher> findSearch(Map whereMap, int page, int size) {
		Specification<Teacher> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return teacherDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Teacher> findSearch(Map whereMap) {
		Specification<Teacher> specification = createSpecification(whereMap);
		return teacherDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Teacher findById(String id) {
		return teacherDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param teacher
	 */
	public void add(Teacher teacher) {
		teacher.setId( idWorker.nextId()+"" );
		teacherDao.save(teacher);
	}

	/**
	 * 修改
	 * @param teacher
	 */
	public void update(Teacher teacher) {
		teacherDao.save(teacher);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		teacherDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Teacher> createSpecification(Map searchMap) {

		return new Specification<Teacher>() {

			@Override
			public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 教师ID
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 用户账号
                if (searchMap.get("userName")!=null && !"".equals(searchMap.get("userName"))) {
                	predicateList.add(cb.like(root.get("userName").as(String.class), "%"+(String)searchMap.get("userName")+"%"));
                }
                // 用户密码
                if (searchMap.get("password")!=null && !"".equals(searchMap.get("password"))) {
                	predicateList.add(cb.like(root.get("password").as(String.class), "%"+(String)searchMap.get("password")+"%"));
                }
                // 所属学院ID
                if (searchMap.get("collegeId")!=null && !"".equals(searchMap.get("collegeId"))) {
                	predicateList.add(cb.like(root.get("collegeId").as(String.class), "%"+(String)searchMap.get("collegeId")+"%"));
                }
                // 学历
                if (searchMap.get("academic")!=null && !"".equals(searchMap.get("academic"))) {
                	predicateList.add(cb.like(root.get("academic").as(String.class), "%"+(String)searchMap.get("academic")+"%"));
                }
                // 毕业院校
                if (searchMap.get("schoolGraduation")!=null && !"".equals(searchMap.get("schoolGraduation"))) {
                	predicateList.add(cb.like(root.get("schoolGraduation").as(String.class), "%"+(String)searchMap.get("schoolGraduation")+"%"));
                }
                // 联系方式
                if (searchMap.get("teacherTel")!=null && !"".equals(searchMap.get("teacherTel"))) {
                	predicateList.add(cb.like(root.get("teacherTel").as(String.class), "%"+(String)searchMap.get("teacherTel")+"%"));
                }
                // 邮箱
                if (searchMap.get("teacherEmail")!=null && !"".equals(searchMap.get("teacherEmail"))) {
                	predicateList.add(cb.like(root.get("teacherEmail").as(String.class), "%"+(String)searchMap.get("teacherEmail")+"%"));
                }
                // 性别
                if (searchMap.get("sex")!=null && !"".equals(searchMap.get("sex"))) {
                	predicateList.add(cb.like(root.get("sex").as(String.class), "%"+(String)searchMap.get("sex")+"%"));
                }
                // 在校状态
                if (searchMap.get("status")!=null && !"".equals(searchMap.get("status"))) {
                	predicateList.add(cb.like(root.get("status").as(String.class), "%"+(String)searchMap.get("status")+"%"));
                }
                // 教师介绍
                if (searchMap.get("desc")!=null && !"".equals(searchMap.get("desc"))) {
                	predicateList.add(cb.like(root.get("desc").as(String.class), "%"+(String)searchMap.get("desc")+"%"));
                }
                // 是否删除
                if (searchMap.get("isDelete")!=null && !"".equals(searchMap.get("isDelete"))) {
                	predicateList.add(cb.like(root.get("isDelete").as(String.class), "%"+(String)searchMap.get("isDelete")+"%"));
                }
                // 备注
                if (searchMap.get("ramark")!=null && !"".equals(searchMap.get("ramark"))) {
                	predicateList.add(cb.like(root.get("ramark").as(String.class), "%"+(String)searchMap.get("ramark")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
