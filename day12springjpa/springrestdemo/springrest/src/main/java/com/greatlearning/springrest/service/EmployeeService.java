package com.greatlearning.springrest.service;

import java.util.List;

import com.greatlearning.springrest.entity.BoxItem;


public interface EmployeeService {
	void addText(int fgid, String name, int is_required, int max_length, int min_length);
	public void addCheckBoxList(long fgid,String name,int is_required,List<BoxItem> boxlist);
}
