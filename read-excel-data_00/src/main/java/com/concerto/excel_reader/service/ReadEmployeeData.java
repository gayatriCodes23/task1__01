package com.concerto.excel_reader.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import com.concerto.excel_reader.controller.GetExcel;
import com.concerto.excel_reader.model.Employee;

@Component("readEmployeeData")
public class ReadEmployeeData extends GetExcel<Employee> {
	private static final Logger logger = LogManager.getLogger(ReadEmployeeData.class);

	@Override
	public Employee processRow(Row row) {
		Employee employee = new Employee();
		try {
			String id = row.getCell(0).toString();
			String name = row.getCell(1).toString();
			String email = row.getCell(2).toString();
			String contactNo = row.getCell(3).toString();

			employee.setId(id);
			employee.setName(name);
			employee.setEmail(email);
			employee.setContactNo(contactNo);

		} catch (Exception e) {
			logger.error("error occurred in Read Teacher Data", e);
		}

		return employee;
	}
}
