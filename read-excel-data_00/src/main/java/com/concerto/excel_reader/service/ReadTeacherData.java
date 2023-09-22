package com.concerto.excel_reader.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.concerto.excel_reader.controller.GetExcel;
import com.concerto.excel_reader.model.Teacher;

@Component("readTeacherData")
@Primary
public class ReadTeacherData extends GetExcel<Teacher> {
	private static final Logger logger = LogManager.getLogger(ReadTeacherData.class);

	@Override
	public Teacher processRow(Row row) {
		Teacher teacher = new Teacher();
		try {
			String id = row.getCell(0).toString();
			String name = row.getCell(1).toString();
			String email = row.getCell(2).toString();
			String contactNo = row.getCell(3).toString();
			String subject = row.getCell(4).toString();

			teacher.setId(id);
			teacher.setName(name);
			teacher.setEmail(email);
			teacher.setContactNo(contactNo);
			teacher.setSubject(subject);

		} catch (Exception e) {
			logger.error("error occurred in Read Teacher Data", e);
		}

		return teacher;
	}
}
