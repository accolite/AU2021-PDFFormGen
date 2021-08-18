package com.greatlearning.springrest.dao;

import java.util.List;

import com.greatlearning.springrest.entity.BoxItem;


public interface EmployeeDAO {
	public void addText(int fgid, String name, int is_required, int max_length, int min_length);

	void addCheckBoxList(int fgid, String name, int is_required, List<BoxItem> boxlist);
}
