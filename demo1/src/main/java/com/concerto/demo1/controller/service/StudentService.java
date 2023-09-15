package com.concerto.demo1.controller.service;

import org.springframework.stereotype.Service;

import com.concerto.demo1.controller.model.Student;

@Service
public class StudentService {

	public Student getStudent() throws CustomException {
	    Student student = new Student();
//	    student.setName("Suyog");
//	    student.setId(0);

	    if (student == null) {
	        throw new CustomException("Student ID cannot be null");
	    }

	    return student;
	}

}
