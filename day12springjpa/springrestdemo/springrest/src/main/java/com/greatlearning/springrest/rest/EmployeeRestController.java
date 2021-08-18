package com.greatlearning.springrest.rest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.greatlearning.springrest.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	
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
	
}
