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

import com.sh.graduate.dao.SquadDao;
import com.sh.graduate.pojo.Squad;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class SquadService {

	@Autowired
	private SquadDao squadDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Squad> findAll() {
		return squadDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Squad> findSearch(Map whereMap, int page, int size) {
		Specification<Squad> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return squadDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Squad> findSearch(Map whereMap) {
		Specification<Squad> specification = createSpecification(whereMap);
		return squadDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Squad findById(String id) {
		return squadDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param squad
	 */
	public void add(Squad squad) {
		squad.setId( idWorker.nextId()+"" );
		squadDao.save(squad);
	}

	/**
	 * 修改
	 * @param squad
	 */
	public void update(Squad squad) {
		squadDao.save(squad);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		squadDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Squad> createSpecification(Map searchMap) {

		return new Specification<Squad>() {

			@Override
			public Predicate toPredicate(Root<Squad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 班级ID
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 所属学院ID
                if (searchMap.get("collegeId")!=null && !"".equals(searchMap.get("collegeId"))) {
                	predicateList.add(cb.like(root.get("collegeId").as(String.class), "%"+(String)searchMap.get("collegeId")+"%"));
                }
                // 班级名称
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
                // 辅导员
                if (searchMap.get("leader")!=null && !"".equals(searchMap.get("leader"))) {
                	predicateList.add(cb.like(root.get("leader").as(String.class), "%"+(String)searchMap.get("leader")+"%"));
                }
                // 辅导员联系方式
                if (searchMap.get("leaderTel")!=null && !"".equals(searchMap.get("leaderTel"))) {
                	predicateList.add(cb.like(root.get("leaderTel").as(String.class), "%"+(String)searchMap.get("leaderTel")+"%"));
                }
                // 辅导员邮箱
                if (searchMap.get("leaderEmail")!=null && !"".equals(searchMap.get("leaderEmail"))) {
                	predicateList.add(cb.like(root.get("leaderEmail").as(String.class), "%"+(String)searchMap.get("leaderEmail")+"%"));
                }
                // 班级介绍
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
