package com.sh.graduate.controller;
import java.util.Map;

import com.sh.api.college.CollegeControllerApi;
import com.sh.graduate.request.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import com.sh.graduate.pojo.College;
import com.sh.graduate.service.CollegeService;

import com.sh.graduate.entity.PageResult;
import com.sh.graduate.entity.Result;
import com.sh.graduate.entity.StatusCode;
import org.springframework.web.bind.annotation.*;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/college")
public class CollegeController implements CollegeControllerApi {

	@Autowired
	private CollegeService collegeService;


	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",collegeService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",collegeService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<College> pageList = collegeService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<College>(pageList.getTotalElements(), pageList.getContent()) );
	}


	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",collegeService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param college
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody College college  ){
		collegeService.add(college);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param college
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody College college, @PathVariable String id ){
		college.setId(id);
		collegeService.update(college);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		collegeService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}

	@Override
	@GetMapping("/list/{page}/{size}")
	public Result findList(@PathVariable("page") int page, @PathVariable("size")int size, RequestData requestData) {
		return null;
	}
}
