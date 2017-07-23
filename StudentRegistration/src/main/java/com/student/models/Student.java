package com.student.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@Column(name="RNO")
	private int rno;
	@Column(name="NAME")
	private String name;
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="STUDENT_COURSE", 
	joinColumns={@JoinColumn(name="RNO")}, 
	inverseJoinColumns={@JoinColumn(name="CNO")})
	private Set<Course> courses = new HashSet<Course>();
	
	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
}
