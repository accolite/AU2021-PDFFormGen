package com.greatlearning.springrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DateTime")
public class DateTime  {

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "id")
	private long id;
	private String Datetime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private int is_required;
	@ManyToOne
	@JoinColumn(name="fg_id")
	private FieldGroup FG;

	@ManyToOne
	@JoinColumn(name="formid")
	private Form FID;
	
	public Date() {
		
	}
	
	public Text(String Datetime, int is_required) {
		this.Datetime = Datetime;
		this.is_required = is_required;
	}
	public String getValue() {
		return Datetime;
	}
	public void setValue(String value) {
		this.Datetime = Datetime;
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
