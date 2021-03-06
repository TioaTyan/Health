package dev.tioachan.service;

import dev.tioachan.domain.CheckGroup;
import dev.tioachan.entity.PageResult;
import dev.tioachan.entity.QueryPageBean;
import dev.tioachan.entity.Result;

import java.util.List;

public interface CheckGroupService {

	void addCheckGroup(CheckGroup groupData, Integer[] checkItemIds);

	PageResult pageQuery(QueryPageBean queryPageBean);

	void edit(CheckGroup tempformData, Integer[] checkitemIds);

	void delGroup(Integer groupId);

	List<CheckGroup> getAll();

	List<Integer> getIdsBySetmealId(Integer id);
}
