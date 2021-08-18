package com.greatlearning.springrest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "fieldgroup")
public class FieldGroup 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	@Column(name ="id")
	private long id;
	
	private String name;
	
	public FieldGroup() {
		
	}
	
	public FieldGroup(String name) {
		this.name = name;
	}
	
//	@OneToMany(mappedBy = "FG", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Num> FTnum = new ArrayList<>();

	@OneToMany (mappedBy = "FG", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Text>  FTtext = new ArrayList<>();

//	@OneToMany (mappedBy = "FG", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Email>  FTemail = new ArrayList<>();
	
//	@OneToMany (mappedBy = "FG", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<CheckBoxList>  FTcheckboxlist = new ArrayList<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Num> getFTnum() {
//		return FTnum;
//	}
//
//	public void setFTnum(ArrayList<Num> fTnum) {
//		FTnum = fTnum;
//	}

	public List<Text> getFTtext() {
		return FTtext;
	}

	public void setFTtext(ArrayList<Text> fTtext) {
		FTtext = fTtext;
	}

	@Override
	public String toString() {
		return "FieldGroup [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
