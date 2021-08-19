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
import javax.persistence.Table;

@Entity
@Table(name = "Password")
public class Password  {

	// value="first_name" is_required=1 max_lenght=30 min_lenght=2 FGid = 1
	
	
	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "id")
	private long id;
	private String value;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private int is_required;
	private int max_length;
	private int min_length;
	@ManyToOne
	@JoinColumn(name="fg_id")
	private FieldGroup FG;

	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "FTtext")
	private List<Form> formlist = new ArrayList<>();
	
	
	
	
	@Override
	public String toString() {
		return "Text [id=" + id + ", value=" + value + ", is_required=" + is_required + ", max_length=" + max_length
				+ ", min_length=" + min_length + "]";
	}
	public Password() {
		
	}
	
	public Password(String name, int is_required, int max_length, int min_length) {
		this.value = name;
		this.is_required = is_required;
		this.max_length = max_length;
		this.min_length = min_length;
	}
	public List<Form> getFormlist() {
		return formlist;
	}
	public void setFormlist(List<Form> formlist) {
		this.formlist = formlist;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getIs_required() {
		return is_required;
	}
	public void setIs_required(int is_required) {
		this.is_required = is_required;
	}
	public int getMax_length() {
		return max_length;
	}
	public void setMax_length(int max_length) {
		this.max_length = max_length;
	}
	public int getMin_length() {
		return min_length;
	}
	public void setMin_length(int min_length) {
		this.min_length = min_length;
	}
	public FieldGroup getFG() {
		return FG;
	}
	public void setFG(FieldGroup fG) {
		FG = fG;
	}
}
