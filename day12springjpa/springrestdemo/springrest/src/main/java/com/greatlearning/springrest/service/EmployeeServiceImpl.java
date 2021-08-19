package com.greatlearning.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.springrest.dao.EmployeeDAO;
import com.greatlearning.springrest.entity.BoxItem;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	


	@Override
	public void addText(int fgid,String name,int is_required,int max_length,int min_length) {
		employeeDAO.addText(fgid, name, is_required, max_length, min_length);
	}




	@Override
	public void addCheckBoxList(long fgid, String name, int is_required, List<BoxItem> boxlist) {
		employeeDAO.addCheckBoxList(fgid, name, is_required, boxlist);
		
	}
}
