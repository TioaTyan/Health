package dev.tioachan.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import dev.tioachan.constant.MessageConstant;
import dev.tioachan.domain.CheckGroup;
import dev.tioachan.domain.CheckItem;
import dev.tioachan.entity.PageResult;
import dev.tioachan.entity.QueryPageBean;
import dev.tioachan.entity.Result;
import dev.tioachan.service.CheckGroupService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/checkgroup")
@CrossOrigin("*")
public class CheckGroupController {

	@Reference
	private CheckGroupService checkGroupService;

	@RequestMapping("/add")
	public Result add(@RequestBody CheckGroup tempformData,Integer[] checkitemIds){
		try {
			checkGroupService.addCheckGroup(tempformData,checkitemIds);
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
		}
		return new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
	}

	@RequestMapping("/edit")
	public Result edit(@RequestBody CheckGroup tempformData,Integer[] checkitemIds){
		try {
			checkGroupService.edit(tempformData,checkitemIds);
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false, MessageConstant.EDIT_CHECKGROUP_FAIL);
		}
		return new Result(true, MessageConstant.EDIT_CHECKGROUP_SUCCESS);
	}

	@RequestMapping("/delete")
	public Result delete(Integer groupId){
		try {
			checkGroupService.delGroup(groupId);
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false, e.getMessage());
		}
		return new Result(true, MessageConstant.DELETE_CHECKGROUP_SUCCESS);
	}

	@RequestMapping("/getAll")
	public Result getAll(){
		try {
			List<CheckGroup> checkGroupList=checkGroupService.getAll();
			return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroupList);
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);
		}
	}

	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
		PageResult pageResult = checkGroupService.pageQuery(queryPageBean);
		return pageResult;
	}

	@RequestMapping("/getIdsBySetmealId")
	public Result getIdsBySetmealId(Integer id){
		try {
			List<Integer> list=checkGroupService.getIdsBySetmealId(id);
			return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,list);
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);
		}
	}
}
