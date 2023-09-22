package com.concerto.excel_reader.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concerto.excel_reader.model.Employee;
import com.concerto.excel_reader.model.Student;
import com.concerto.excel_reader.model.Teacher;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Copyright (C) Concerto Software and Systems (P) LTD | All Rights Reserved
 *
 * @File : com.concerto.excel_reader.Controller.java
 * @Author : Gayatri Hande
 * @AddedDate : Sept 07, 2023 3:30:40 PM
 * @ModifiedBy :
 * @ModifiedDate :
 * @Purpose : endpoints to read data from excel files
 * @Version : 1.0
 */

@RestController
@RequestMapping("api/read")
public class Controller {

	private static final Logger logger = LogManager.getLogger(Controller.class);

	@Value("${excel.file.path.teacher-details}")
	private String teacherDetailsExcelFilePath;

	@Value("${excel.file.path.student-details}")
	private String studentDetailsExcelFilePath;

	@Value("${excel.file.path.student-details}")
	private String employeeDetailsExcelFilePath;

	@Autowired
	@Qualifier("readTeacherData")
	private GetExcel<Teacher> readTeacherData;

	@Autowired
	private GetExcel<Student> readStudentData;

	@Autowired
	private GetExcel<Employee> readEmployeeData;

	@Autowired
	private GetExcel excel;

	@GetMapping("/teachers")
	public void readTeacherData() {
		
		List<Teacher> teachers = excel.excelFile(teacherDetailsExcelFilePath, readTeacherData);
		for (Teacher teacher : teachers) {
			logger.info(teacher);
		}
	}

	@GetMapping("/students")
	public void readStudentData() {

		List<Student> students = excel.excelFile(studentDetailsExcelFilePath, readStudentData);
		for (Student student : students) {
			logger.info(student);
		}
	}

	@GetMapping("/employee")
	public void readEmployeeData() {

		List<Employee> employees = excel.excelFile(employeeDetailsExcelFilePath, readEmployeeData);
		for (Employee employee : employees) {
			logger.info(employee);
		}
	}
}
