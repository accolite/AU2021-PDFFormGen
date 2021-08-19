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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "form")
public class Form {



	public void setFTtext(List<Text> fTtext) {
		FTtext = fTtext;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	@Column(name ="id")
	private long id;
	
	private String name;
	
	public Form() {
		
	}
	
	public Form(String name) {
		this.name = name;
	}
	
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	private List<Num> FTNum=new ArrayList<>();
	

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name = "form_text",
			joinColumns = { @JoinColumn(name = "form_id") },
			inverseJoinColumns = { @JoinColumn(name = "text_id") }
			)

	private List<Text>  FTtext = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	private List<Email>  FTemail = new ArrayList<>();
	
//	@OneToMany (mappedBy = "formid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	private List<CheckBoxList>  FTcheckboxlist = new ArrayList<>();
	
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
		return "Form [id=" + id + ", name=" + name + "]";
	}
}
