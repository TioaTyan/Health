package dev.tioachan.service;

import dev.tioachan.domain.CheckGroup;
import dev.tioachan.entity.PageResult;
import dev.tioachan.entity.QueryPageBean;

import java.util.List;

public interface CheckGroupService {
	List<CheckGroup> getCheckItem();

	void addCheckGroup(CheckGroup groupData, Integer[] checkItemIds);

	PageResult pageQuery(QueryPageBean queryPageBean);
}
