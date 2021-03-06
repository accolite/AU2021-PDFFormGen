package com.greatlearning.springrest.dao;

import java.util.List;

import org.json.JSONObject;

import com.greatlearning.springrest.entity.BoxItem;
import com.greatlearning.springrest.entity.Password;


public interface EmployeeDAO {
	public void addText(int fgid, String name, int is_required, int max_length, int min_length);

	void addCheckBoxList(int fgid, String name, int is_required, List<BoxItem> boxlist);

	public void addFieldGroup(String string);

	public String getfg(int i);
	
	
	public void addCheckBox(int fgid,String name,int is_required,String value);
	
	public void addDate(int fgid,String name,int is_required,String value);
	
	public void addDateTime(int fgid,String name,int is_required,String value);
	
	public void addEmail(int fgid,String name,int is_required,String value);
	
	public void addNum(int fgid,String name,int is_required,int max_length, int min_length);
	
	public void addPassword(int fgid,String name,int is_required, int max_length, int min_length);
	
	public void addTextarea(int fgid,String name,int is_required, int max_length, int min_length);

	public void createform(String string, List<Integer> textl, List<Integer> checkboxlistl, List<Integer> passwordl);

	public JSONObject getform(int i);

	public String getfgs();
	
}
