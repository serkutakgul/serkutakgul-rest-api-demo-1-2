package com.srkt.obsdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="students")
public class Student {
	@Id
	@Column(name="student_no")
	private Integer no;
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="status")
	private String status;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
/*
	public Student(Integer no, String studentName, String status) {
		super();
		this.no = no;
		this.studentName = studentName;
		this.status = status;
	}*/

	public Student() {
		this.status="bekliyor";
	}

	public Student(Integer no, String studentName) {
		super();
		this.no = no;
		this.studentName = studentName;
		//this.status="bekliyor";
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", studentName=" + studentName + ", status=" + status + "]";
	}
	
	
	
	
	
}
