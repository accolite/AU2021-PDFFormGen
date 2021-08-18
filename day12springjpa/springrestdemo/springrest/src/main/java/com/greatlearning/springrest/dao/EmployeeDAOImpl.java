package com.greatlearning.springrest.dao;

import java.util.List;

import org.hibernate.*;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.springrest.entity.BoxItem;
import com.greatlearning.springrest.entity.CheckBoxList;
import com.greatlearning.springrest.entity.FieldGroup;
import com.greatlearning.springrest.entity.Text;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private EntityManager entityManager;
	


	
	
	@Override
	@Transactional
	public void addText(int fgid,String name,int is_required,int max_length,int min_length) {
		System.out.println("coming");
		Session currentSession1 = entityManager.unwrap(Session.class);
		long id = fgid;
		FieldGroup fg = currentSession1.get(FieldGroup.class, id);
		System.out.println(fg);
		Text t = new Text(name,is_required,max_length,min_length);
		t.setFG(fg);
		fg.getFTtext().add(t);
		currentSession1.update(fg);
	}
	
	@Override
	@Transactional
	public void addCheckBoxList(int fgid,String name,int is_required,List<BoxItem> boxlist) {
//		System.out.println("coming");
		Session currentSession1 = entityManager.unwrap(Session.class);
		long id = fgid;
		FieldGroup fg = currentSession1.get(FieldGroup.class, id);
//		System.out.println(fg);
//		Text t = new Text(name,is_required,max_length,min_length);
//		t.setFG(fg);
//		fg.getFTtext().add(t);
//		currentSession1.update(fg);
		CheckBoxList cbl = new CheckBoxList(name,is_required);
		cbl.setBoxItems(boxlist);
		Session currentSession = entityManager.unwrap(Session.class);
		cbl.setFG(fg);
		currentSession.save(cbl);
		
	}
	
	
}