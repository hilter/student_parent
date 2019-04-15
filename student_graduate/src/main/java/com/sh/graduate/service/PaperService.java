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

import com.sh.graduate.dao.PaperDao;
import com.sh.graduate.pojo.Paper;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class PaperService {

	@Autowired
	private PaperDao paperDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Paper> findAll() {
		return paperDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Paper> findSearch(Map whereMap, int page, int size) {
		Specification<Paper> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return paperDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Paper> findSearch(Map whereMap) {
		Specification<Paper> specification = createSpecification(whereMap);
		return paperDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Paper findById(String id) {
		return paperDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param paper
	 */
	public void add(Paper paper) {
		paper.setId( idWorker.nextId()+"" );
		paperDao.save(paper);
	}

	/**
	 * 修改
	 * @param paper
	 */
	public void update(Paper paper) {
		paperDao.save(paper);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		paperDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Paper> createSpecification(Map searchMap) {

		return new Specification<Paper>() {

			@Override
			public Predicate toPredicate(Root<Paper> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 学生ID
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 论文地址
                if (searchMap.get("paperUrl")!=null && !"".equals(searchMap.get("paperUrl"))) {
                	predicateList.add(cb.like(root.get("paperUrl").as(String.class), "%"+(String)searchMap.get("paperUrl")+"%"));
                }
                // 评分状态
                if (searchMap.get("hasScore")!=null && !"".equals(searchMap.get("hasScore"))) {
                	predicateList.add(cb.like(root.get("hasScore").as(String.class), "%"+(String)searchMap.get("hasScore")+"%"));
                }
                // 论文分数
                if (searchMap.get("paperGrade")!=null && !"".equals(searchMap.get("paperGrade"))) {
                	predicateList.add(cb.like(root.get("paperGrade").as(String.class), "%"+(String)searchMap.get("paperGrade")+"%"));
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
