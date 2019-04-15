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

import com.sh.graduate.dao.StudentDao;
import com.sh.graduate.pojo.Student;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Student> findSearch(Map whereMap, int page, int size) {
		Specification<Student> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return studentDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Student> findSearch(Map whereMap) {
		Specification<Student> specification = createSpecification(whereMap);
		return studentDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Student findById(String id) {
		return studentDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param student
	 */
	public void add(Student student) {
		student.setId( idWorker.nextId()+"" );
		studentDao.save(student);
	}

	/**
	 * 修改
	 * @param student
	 */
	public void update(Student student) {
		studentDao.save(student);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		studentDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Student> createSpecification(Map searchMap) {

		return new Specification<Student>() {

			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 学生ID
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
                // 所属班级ID
                if (searchMap.get("classId")!=null && !"".equals(searchMap.get("classId"))) {
                	predicateList.add(cb.like(root.get("classId").as(String.class), "%"+(String)searchMap.get("classId")+"%"));
                }
                // 导师ID
                if (searchMap.get("tutorId")!=null && !"".equals(searchMap.get("tutorId"))) {
                	predicateList.add(cb.like(root.get("tutorId").as(String.class), "%"+(String)searchMap.get("tutorId")+"%"));
                }
                // 联系方式
                if (searchMap.get("studentTel")!=null && !"".equals(searchMap.get("studentTel"))) {
                	predicateList.add(cb.like(root.get("studentTel").as(String.class), "%"+(String)searchMap.get("studentTel")+"%"));
                }
                // 邮箱
                if (searchMap.get("student_email")!=null && !"".equals(searchMap.get("student_email"))) {
                	predicateList.add(cb.like(root.get("student_email").as(String.class), "%"+(String)searchMap.get("student_email")+"%"));
                }
                // 性别
                if (searchMap.get("sex")!=null && !"".equals(searchMap.get("sex"))) {
                	predicateList.add(cb.like(root.get("sex").as(String.class), "%"+(String)searchMap.get("sex")+"%"));
                }
                // 论文ID
                if (searchMap.get("paperId")!=null && !"".equals(searchMap.get("paperId"))) {
                	predicateList.add(cb.like(root.get("paperId").as(String.class), "%"+(String)searchMap.get("paperId")+"%"));
                }
                // 论文上传状态
                if (searchMap.get("uploadStatus")!=null && !"".equals(searchMap.get("uploadStatus"))) {
                	predicateList.add(cb.like(root.get("uploadStatus").as(String.class), "%"+(String)searchMap.get("uploadStatus")+"%"));
                }
                // 在校状态
                if (searchMap.get("status")!=null && !"".equals(searchMap.get("status"))) {
                	predicateList.add(cb.like(root.get("status").as(String.class), "%"+(String)searchMap.get("status")+"%"));
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
