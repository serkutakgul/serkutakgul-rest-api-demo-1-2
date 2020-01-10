package com.srkt.obsdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.srkt.obsdemo.dao.StudentRepository;
import com.srkt.obsdemo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository sr;
	
	@Autowired
	public StudentServiceImpl(StudentRepository srep) {
		sr = srep;
	}
	
	@Override
	public List<Student> findAll() {
		return sr.findAll();
	}

	@Override
	public Student findById(int theId) {
		Optional<Student> result = sr.findById(theId);
		
		Student stu = null;
		
		if (result.isPresent()) {
			stu = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Ogrenci yok  " + theId);
		}
		
		return stu;
	}

	@Override
	public void save(Student stu) {
		sr.save(stu);
	}

	@Override
	public void deleteById(int theId) {
		sr.deleteById(theId);
	}

}






