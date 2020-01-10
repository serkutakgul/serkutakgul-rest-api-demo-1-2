package com.srkt.obsdemo.service;

import java.util.List;

import com.srkt.obsdemo.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save(Student stu);
	
	public void deleteById(int theId);
	
}
