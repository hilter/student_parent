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

import com.sh.graduate.dao.CollegeDao;
import com.sh.graduate.pojo.College;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class CollegeService {

	@Autowired
	private CollegeDao collegeDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<College> findAll() {
		return collegeDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<College> findSearch(Map whereMap, int page, int size) {
		Specification<College> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return collegeDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<College> findSearch(Map whereMap) {
		Specification<College> specification = createSpecification(whereMap);
		return collegeDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public College findById(String id) {
		return collegeDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param college
	 */
	public void add(College college) {
		college.setId( idWorker.nextId()+"" );
		collegeDao.save(college);
	}

	/**
	 * 修改
	 * @param college
	 */
	public void update(College college) {
		collegeDao.save(college);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		collegeDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<College> createSpecification(Map searchMap) {

		return new Specification<College>() {

			@Override
			public Predicate toPredicate(Root<College> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 学院ID
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 学院名称
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
                // 学院领导
                if (searchMap.get("leader")!=null && !"".equals(searchMap.get("leader"))) {
                	predicateList.add(cb.like(root.get("leader").as(String.class), "%"+(String)searchMap.get("leader")+"%"));
                }
                // 学院介绍
                if (searchMap.get("desc")!=null && !"".equals(searchMap.get("desc"))) {
                	predicateList.add(cb.like(root.get("desc").as(String.class), "%"+(String)searchMap.get("desc")+"%"));
                }
                // 状态
                if (searchMap.get("status")!=null && !"".equals(searchMap.get("status"))) {
                	predicateList.add(cb.like(root.get("status").as(String.class), "%"+(String)searchMap.get("status")+"%"));
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
