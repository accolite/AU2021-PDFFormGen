package com.greatlearning.springrest.dao;

import java.util.List;

import org.json.JSONObject;

import com.greatlearning.springrest.entity.BoxItem;


public interface EmployeeDAO {
	public void addText(int fgid, String name, int is_required, int max_length, int min_length);

	void addCheckBoxList(int fgid, String name, int is_required, List<BoxItem> boxlist);

	public void addFieldGroup(String string);

	public JSONObject getfg(int i);
}
