package com.srkt.obsdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.srkt.obsdemo.dao.StudentRepository;
import com.srkt.obsdemo.entity.Banka;
import com.srkt.obsdemo.entity.Student;
import com.srkt.obsdemo.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	 static final String restURI="http://localhost:8005/api/borclar";
	 static RestTemplate restTemplate=new RestTemplate();
	@Autowired
	private StudentService ss;
	private StudentRepository sr;
	public StudentController(StudentService tss) {
		ss=tss;
	}
	
	@GetMapping("/list")
public String list(Model model) {
		
		// get employees from db
		List<Student> stu = ss.findAll();
		
		// add to the spring model
		model.addAttribute("students", stu);
		
		return "students/list-students";
	}
	@GetMapping("/{no}")
	public String getStudent(Model model ,@PathVariable int no) {
		
		Student stu = ss.findById(no);
		
		if (stu == null) {
			throw new RuntimeException("ogrenci yok - " + no);
		}
		model.addAttribute("students", stu);
		return "students/list-students";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Student stu = new Student();
		
		theModel.addAttribute("student", stu);
		
		return "students/student-form";
	}
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student stu) {
		
		// save the employee
		ss.save(stu);
		restTemplate.postForEntity(restURI, stu, Student.class);
		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";
	}
	
}
