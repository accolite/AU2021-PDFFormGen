package com.greatlearning.springrest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "checkboxlist")
public class CheckBoxList {
	public List<Form> getFormlist() {
		return formlist;
	}

	public void setFormlist(List<Form> formlist) {
		this.formlist = formlist;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "id")
	private long id;
	String value;
	int is_required;
	@OneToMany(mappedBy = "CB", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BoxItem> boxItems = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="fg_id")
	private FieldGroup FG;

	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "FTcheckboxlist")
	private List<Form> formlist = new ArrayList<>();
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<BoxItem> getBoxItems() {
		return boxItems;
	}

	public void setBoxItems(List<BoxItem> boxItems) {
		this.boxItems = boxItems;
	}

	public FieldGroup getFG() {
		return FG;
	}

	public void setFG(FieldGroup fG) {
		FG = fG;
	}
	
	public CheckBoxList() {
		
	}
	
	public CheckBoxList(String value,int is_required) {
		
	}
	
}
