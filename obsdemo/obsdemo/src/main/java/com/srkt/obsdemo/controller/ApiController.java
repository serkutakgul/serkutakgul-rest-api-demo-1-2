package com.srkt.obsdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.srkt.obsdemo.dao.StudentRepository;
import com.srkt.obsdemo.entity.Banka;
import com.srkt.obsdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private StudentRepository sr;

	@GetMapping("/odendi/{id}") 
	public Student addBorc(@PathVariable Integer id) {
		Student stud = sr.findById(id).orElse(null);
		
		stud.setStatus("Aktif");
		sr.save(stud);
		
		return stud;
	}
}
