package com.greatlearning.springrest.rest;

import java.util.LinkedHashMap;
import java.util.List;

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
	@PostMapping("/addText")
	public void addText(@RequestBody Object obj)
	{
//		String s = obj.toString();
//		JsonObject object = Json.parse(s).asObject();
//		int id = object.get("fgid").asInt();
//		System.out.println(id);
//		employeeservice.addText(obj.fgid, obj.name, obj.is_required, obj.max_length, obj.min_length);
		LinkedHashMap mp = (LinkedHashMap) obj;
		employeeservice.addText((int)mp.get("fgid"),(String)mp.get("name"),(int)mp.get("is_required"),(int)mp.get("max_length"),(int)mp.get("min_length"));
//		int id = obj.
		
		System.out.println(mp.get("fgid"));
		System.out.println(obj);
	}
	
	
}
