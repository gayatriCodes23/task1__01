package com.concerto.excel_reader.model;

import java.text.DecimalFormat;

public class Teacher {

	private String id;
	private String name;
	private String email;
	private String contactNo;
	private String subject;

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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("0");
		return "Teacher [id=" + decimalFormat.format(Double.parseDouble(id)) + ", name=" + name + ", email=" + email + ", contactNo=" + decimalFormat.format(Double.parseDouble(contactNo)) + ", subject="
				+ subject + "]";
	}

}