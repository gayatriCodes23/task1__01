package com.concerto.excel_reader.model;

import java.text.DecimalFormat;

public class Employee {

	private String id;
	private String name;
	private String email;
	private String contactNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("0");
		return "Employee [id=" + decimalFormat.format(Double.parseDouble(id)) + ", name=" + name + ", email=" + email
				+ ", contactNo=" + decimalFormat.format(Double.parseDouble(contactNo)) + "]";
	}

}