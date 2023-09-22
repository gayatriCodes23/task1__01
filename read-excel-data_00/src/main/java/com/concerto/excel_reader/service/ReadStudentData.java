package com.concerto.excel_reader.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import com.concerto.excel_reader.controller.GetExcel;
import com.concerto.excel_reader.model.Student;

@Component("readStudentData")
public class ReadStudentData extends GetExcel<Student> {
	private static final Logger logger = LogManager.getLogger(ReadStudentData.class);

	public Student processRow(Row row) {
		Student student = new Student();
		try {
			String id = row.getCell(0).toString();
			String name = row.getCell(1).toString();
			String email = row.getCell(2).toString();
			String contactNo = row.getCell(3).toString();

			student.setId(id);
			student.setName(name);
			student.setEmail(email);
			student.setContactNo(contactNo);

		} catch (Exception e) {
			logger.error("error occurred in Reading Student Data", e);
		}

		return student;
	}
}