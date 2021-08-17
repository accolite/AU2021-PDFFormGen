package com.greatlearning.springrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "checkboxlist")
public class BoxItem {
	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "id")
	private long id;
	String value;
	String text;
	@ManyToOne
	@JoinColumn(name="boxid")
	private CheckBoxList CB;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public CheckBoxList getCB() {
		return CB;
	}
	public void setCB(CheckBoxList cB) {
		CB = cB;
	}
	
}
