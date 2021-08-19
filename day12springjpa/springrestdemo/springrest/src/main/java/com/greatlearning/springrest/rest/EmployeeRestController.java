package com.greatlearning.springrest.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.springrest.dao.EmployeeDAO;
import com.greatlearning.springrest.entity.BoxItem;
import com.greatlearning.springrest.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private EmployeeService employeeservice;
//	@Autowired
//	public EmployeeRestController(EmployeeService theEmpService) {
//	
	@PostMapping("/addtext")
	public void addText(@RequestBody LinkedHashMap mp )
	{
//		mp.keySet()
//		System.out.println(mp.get("val"));
//		Set<String> lk = ((LinkedHashMap) mp.get("val")).keySet();
//		System.out.println(lk);
		employeeservice.addText((int)mp.get("fgid"),(String)mp.get("name"),(int)mp.get("is_required"),(int)mp.get("max_length"),(int)mp.get("min_length"));
//		int id = obj.
		
//		System.out.println(mp.get("fgid"));
//		System.out.println(obj);
	}
	
	@PostMapping("/addCheckboxlist")
	public void addCheckBoxList(@RequestBody LinkedHashMap mp)
	{
		List<BoxItem> bl = new ArrayList<>();
		Collection<String> lk = ((LinkedHashMap) mp.get("val")).keySet();
		System.out.println(lk);
//		System.out.println(lv);
		for(String s: lk)
		{
			bl.add(new BoxItem(s,(String) ((LinkedHashMap) mp.get("val")).get(s)));
		}
		System.out.println(bl);
		
		employeeDAO.addCheckBoxList((int)mp.get("fgid"), (String)mp.get("name"), (int)mp.get("is_required"), bl);
	}
	
	@PostMapping("/addfieldgroup")
	public void addfieldgroup(@RequestBody LinkedHashMap mp)
	{
		employeeDAO.addFieldGroup((String)mp.get("name"));
	}
	
	@PostMapping("/getfg")
	public String getfg(@RequestBody LinkedHashMap mp) {
		return employeeDAO.getfg((int)mp.get("fgid")).toString();
	}
	
	
	
	@PostMapping("/addCheckbox")
	public void addCheckBox(@RequestBody LinkedHashMap mp) {
		
	}
	
	@PostMapping("/addDate")
	public void addDate(@RequestBody LinkedHashMap mp) {
		
	}
	
	@PostMapping("/addDateTime")
	public void addDateTime(@RequestBody LinkedHashMap mp) {
		
	}
	
	@PostMapping("/addEmail")
	public void addEmail(@RequestBody LinkedHashMap mp) {
		
	}
	
	@PostMapping("/addNum")
	public void addNum(@RequestBody LinkedHashMap mp) {
		employeeDAO.addNum((int)mp.get("fgid"),(String)mp.get("value"),(int)mp.get("is_required"),(int)mp.get("max_length"),(int)mp.get("min_length"));
	}
	
	@PostMapping("/addPassword")
	public void addPassword(@RequestBody LinkedHashMap mp) {
		employeeDAO.addPassword((int)mp.get("fgid"),(String)mp.get("value"),(int)mp.get("is_required"),(int)mp.get("max_length"),(int)mp.get("min_length"));
	}
	
	@PostMapping("/addTextArea")
	public void addTextArea(@RequestBody LinkedHashMap mp) {
		
	}
	
	@PostMapping("/createform")
	public void createform(@RequestBody LinkedHashMap mp) {
		List<Integer> textl = (List<Integer>) mp.get("text");
		List<Integer> checkboxlistl = (List<Integer>) mp.get("checkboxlist");
		employeeDAO.createform((String)mp.get("name"),textl,checkboxlistl);
	}
	
}
