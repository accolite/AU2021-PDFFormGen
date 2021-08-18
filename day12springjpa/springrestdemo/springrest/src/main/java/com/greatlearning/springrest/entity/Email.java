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
@Table(name = "email")
public class Email {

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "id")
	private long id;
	private String value;
	private int is_required;
	@ManyToOne
	@JoinColumn(name="fg_id")
	private FieldGroup FG;
	public long getId() {
		return id;
	}
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "FTemail")
	private List<Form> formlist = new ArrayList<>();
	
	public void setId(long id) {
		this.id = id;
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
	public FieldGroup getFG() {
		return FG;
	}
	public void setFG(FieldGroup fG) {
		FG = fG;
	}
	
}
