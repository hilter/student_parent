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

import com.sh.graduate.dao.SystemUserDao;
import com.sh.graduate.pojo.SystemUser;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class SystemUserService {

	@Autowired
	private SystemUserDao systemUserDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<SystemUser> findAll() {
		return systemUserDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<SystemUser> findSearch(Map whereMap, int page, int size) {
		Specification<SystemUser> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return systemUserDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<SystemUser> findSearch(Map whereMap) {
		Specification<SystemUser> specification = createSpecification(whereMap);
		return systemUserDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public SystemUser findById(String id) {
		return systemUserDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param systemUser
	 */
	public void add(SystemUser systemUser) {
		systemUser.setId( idWorker.nextId()+"" );
		systemUserDao.save(systemUser);
	}

	/**
	 * 修改
	 * @param systemUser
	 */
	public void update(SystemUser systemUser) {
		systemUserDao.save(systemUser);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		systemUserDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<SystemUser> createSpecification(Map searchMap) {

		return new Specification<SystemUser>() {

			@Override
			public Predicate toPredicate(Root<SystemUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // ID
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
                // 备注
                if (searchMap.get("ramark")!=null && !"".equals(searchMap.get("ramark"))) {
                	predicateList.add(cb.like(root.get("ramark").as(String.class), "%"+(String)searchMap.get("ramark")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
