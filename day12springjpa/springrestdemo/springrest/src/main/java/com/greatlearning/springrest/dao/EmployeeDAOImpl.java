package com.greatlearning.springrest.dao;

import java.util.List;

import org.hibernate.*;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greatlearning.springrest.entity.BoxItem;
import com.greatlearning.springrest.entity.CheckBoxList;
import com.greatlearning.springrest.entity.FieldGroup;
import com.greatlearning.springrest.entity.Form;
import com.greatlearning.springrest.entity.Num;
import com.greatlearning.springrest.entity.Password;
import com.greatlearning.springrest.entity.Text;

import org.json.*;
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
		for(BoxItem b: boxlist) {
			b.setCB(cbl);
			cbl.getBoxItems().add(b);
		}
//		cbl.setBoxItems(boxlist);
		Session currentSession = entityManager.unwrap(Session.class);
		cbl.setFG(fg);
		currentSession.save(cbl);
		
	}

	@Override
	public void addFieldGroup(String string) {
		FieldGroup fg = new FieldGroup(string);
		Session currentSession1 = entityManager.unwrap(Session.class);
		currentSession1.save(fg);
		
	}

	@Override
	@Transactional
	public JSONObject getfg(int i) {
		Session currentSession1 = entityManager.unwrap(Session.class);
		long id = i;
		FieldGroup fg = currentSession1.get(FieldGroup.class, id);
		List<Text> FTtext = fg.getFTtext();
	    System.out.println(FTtext);
		JSONObject res = new JSONObject();
	    JSONArray jsonArray = new JSONArray();
	    for(Text t: FTtext) {
	    	JSONObject obj = new JSONObject();
	    	try {
	    		obj.put("id", t.getId());
		    	obj.put("value", t.getValue());
				obj.put("is_required", t.getIs_required());
				obj.put("max_length", t.getMax_length());
				obj.put("min_length", t.getMin_length());
				jsonArray.put(obj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
//	    System.out.println(res);
	    JSONArray cblarr = new JSONArray();
	    List<CheckBoxList> cbl = fg.getFTcheckboxlist();
	    
	    
	    try {
	    	for(CheckBoxList cb: cbl) {
		    	JSONObject cbli = new JSONObject();
		    	List<BoxItem> bi = cb.getBoxItems();
		    	JSONObject valobj = new JSONObject();
			    	for(BoxItem b: bi) {
			    		valobj.put(b.getValue(), b.getText());
			    	}
			    cbli.put("id", cb.getId());
		    	cbli.put("name", cb.getValue());
		    	cbli.put("is_required", cb.getIs_required());
		    	cbli.put("val", valobj);
		    	cblarr.put(cbli);
		    }
	    	
	    }
	    catch(Exception e) {
	    	
	    }

	    
	    JSONArray numarr = new JSONArray();
	    List<Num> numl = fg.getFTNum();
	    
	    for(Num n: numl) {
	    	JSONObject obj = new JSONObject();
	    	try {
	    		obj.put("id", n.getId());
		    	obj.put("value", n.getValue());
				obj.put("is_required", n.getIs_required());
				obj.put("max_length", n.getMax_length());
				obj.put("min_length", n.getMin_length());
				numarr.put(obj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    JSONArray passwordarr = new JSONArray();
	    List<Password> passl = fg.getFTPassword();
	    
	    for(Password n: passl) {
	    	JSONObject obj = new JSONObject();
	    	try {
	    		obj.put("id", n.getId());
		    	obj.put("value", n.getValue());
				obj.put("is_required", n.getIs_required());
				obj.put("max_length", n.getMax_length());
				obj.put("min_length", n.getMin_length());
				passwordarr.put(obj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    
	    
	    try {
			res.put("text", jsonArray);
		    res.put("checkboxlist", cblarr);
		    res.put("number", numarr);
		    res.put("password", passwordarr);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return res;
//	    ObjectMapper mapper = new ObjectMapper();
	    
//	    System.out.println(responseDetailsJson);
	}

	@Override
	@Transactional
	public void addCheckBox(int fgid, String name, int is_required, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void addDate(int fgid, String name, int is_required, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void addDateTime(int fgid, String name, int is_required, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void addEmail(int fgid, String name, int is_required, String value) {
		
	}



	@Override
	@Transactional
	public void addPassword(int fgid, String name, int is_required, int max_length, int min_length) {
		// TODO Auto-generated method stub
		System.out.println(name);
		Session currentSession1 = entityManager.unwrap(Session.class);
		long id = fgid;
		FieldGroup fg = currentSession1.get(FieldGroup.class, id);
		System.out.println(fg);
		Password t = new Password(name,is_required,max_length,min_length);
		t.setFG(fg);
		fg.getFTPassword().add(t);
		currentSession1.update(fg);
		
	}

	@Override
	@Transactional
	public void addTextarea(int fgid, String name, int is_required, int max_length, int min_length) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	@Transactional
	public void addNum(int fgid, String name, int is_required, int max_length, int min_length) {
		// TODO Auto-generated method stub
		Session currentSession1 = entityManager.unwrap(Session.class);
		long id = fgid;
		FieldGroup fg = currentSession1.get(FieldGroup.class, id);
		System.out.println(fg);
		Num t = new Num(name,is_required,max_length,min_length);
		t.setFG(fg);
		fg.getFTNum().add(t);
		currentSession1.update(fg);
	}

	@Override
	@Transactional
	public void createform(String string, List<Integer> textl, List<Integer> checkboxlistl,List<Integer> passwordl) {

		Form f = new Form(string);
		for(Integer i: textl) {
			Session currentSession1 = entityManager.unwrap(Session.class);
			long id = i;
			Text t = currentSession1.get(Text.class, id);
			f.getFTtext().add(t);
		}
		
		for(Integer i: checkboxlistl) {
			Session currentSession1 = entityManager.unwrap(Session.class);
			long id = i;
			CheckBoxList t = currentSession1.get(CheckBoxList.class, id);
			f.getFTcheckboxlist().add(t);
		}
		for(Integer i: passwordl) {
			Session currentSession1 = entityManager.unwrap(Session.class);
			long id = i;
			Password t = currentSession1.get(Password.class, id);
			f.getFTPassword().add(t);
		}
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(f);
//		Session currentSession2 = entityManager.unwrap(Session.class);
		
	}

	@Override
	@Transactional
	public JSONObject getform(int i) {
		Session currentSession1 = entityManager.unwrap(Session.class);
		long id = i;
		Form fg = currentSession1.get(Form.class, id);
		List<Text> FTtext = fg.getFTtext();
	    System.out.println(FTtext);
		JSONObject res = new JSONObject();
	    JSONArray jsonArray = new JSONArray();
	    for(Text t: FTtext) {
	    	JSONObject obj = new JSONObject();
	    	try {
	    		obj.put("id", t.getId());
		    	obj.put("value", t.getValue());
				obj.put("is_required", t.getIs_required());
				obj.put("max_length", t.getMax_length());
				obj.put("min_length", t.getMin_length());
				jsonArray.put(obj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
//	    System.out.println(res);
	    JSONArray cblarr = new JSONArray();
	    List<CheckBoxList> cbl = fg.getFTcheckboxlist();
	    
	    
	    try {
	    	for(CheckBoxList cb: cbl) {
		    	JSONObject cbli = new JSONObject();
		    	List<BoxItem> bi = cb.getBoxItems();
		    	JSONObject valobj = new JSONObject();
			    	for(BoxItem b: bi) {
			    		valobj.put(b.getValue(), b.getText());
			    	}
			    cbli.put("id", cb.getId());
		    	cbli.put("name", cb.getValue());
		    	cbli.put("is_required", cb.getIs_required());
		    	cbli.put("val", valobj);
		    	cblarr.put(cbli);
		    }
	    	
	    }
	    catch(Exception e) {
	    	
	    }

	    
	    JSONArray numarr = new JSONArray();
	    List<Num> numl = fg.getFTNum();
	    
	    for(Num n: numl) {
	    	JSONObject obj = new JSONObject();
	    	try {
	    		obj.put("id", n.getId());
		    	obj.put("value", n.getValue());
				obj.put("is_required", n.getIs_required());
				obj.put("max_length", n.getMax_length());
				obj.put("min_length", n.getMin_length());
				numarr.put(obj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    JSONArray passwordarr = new JSONArray();
	    List<Password> passl = fg.getFTPassword();
	    
	    for(Password n: passl) {
	    	JSONObject obj = new JSONObject();
	    	try {
	    		obj.put("id", n.getId());
		    	obj.put("value", n.getValue());
				obj.put("is_required", n.getIs_required());
				obj.put("max_length", n.getMax_length());
				obj.put("min_length", n.getMin_length());
				passwordarr.put(obj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    
	    
	    try {
			res.put("text", jsonArray);
		    res.put("checkboxlist", cblarr);
		    res.put("number", numarr);
		    res.put("password", passwordarr);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return res;
	}
	

}