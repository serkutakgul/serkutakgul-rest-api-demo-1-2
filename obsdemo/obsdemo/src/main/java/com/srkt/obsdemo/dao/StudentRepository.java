package com.srkt.obsdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srkt.obsdemo.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
}
