package com.doeasy.model.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String gender;
	private Date birthday;
	
	public Person (){}
	
    public Person(String name, String gender, Date birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }	

}
