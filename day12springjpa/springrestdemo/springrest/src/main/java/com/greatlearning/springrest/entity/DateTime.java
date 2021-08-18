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
	private String datetime;
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
	
	public DateTime() {
		
	}
	
	public DateTime(String Datetime, int is_required) {
		this.datetime = Datetime;
		this.is_required = is_required;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String Datetime) {
		this.datetime = Datetime;
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
