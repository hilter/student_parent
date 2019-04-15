package com.sh.api.college;

import com.sh.graduate.entity.Result;
import com.sh.graduate.request.RequestData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

/**
 * @author 麦客子
 * @desc
 * @email leeshuhua@163.com
 * @create 2019/04/14 18:15
 **/
@Api(value = "学院管理接口", description = "学院管理接口，提供学院的增、删、改、查")
public interface CollegeControllerApi {

    /**
     * 页面查询
     */
    @ApiOperation("分页查询学院列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
    })
    public Result findList(int page, int size, RequestData requestData);

}
