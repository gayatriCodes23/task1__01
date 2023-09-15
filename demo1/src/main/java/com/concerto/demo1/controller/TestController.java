package com.concerto.demo1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concerto.demo1.controller.model.Student;
import com.concerto.demo1.controller.service.CustomException;
import com.concerto.demo1.controller.service.StudentService;

@RestController
public class TestController {

	@Autowired
	StudentService studentService;

	@GetMapping("/hi")
	public String getData() {

		return "Hellow from controller";
	}

	@GetMapping("/student")
	public void getStudent() {
		
		String str = "Hello";
		int num = Integer.parseInt(str); // This will throw a NumberFormatException

	}

}
