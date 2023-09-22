package com.concerto.excel_reader.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

/**
 * Copyright (C) Concerto Software and Systems (P) LTD | All Rights Reserved
 *
 * @File : com.concerto.excel_reader.GetExcel.java
 * @Author : Gayatri Hande
 * @AddedDate : Sept 07, 2023 3:30:40 PM
 * @ModifiedBy :
 * @ModifiedDate :
 * @Purpose : read data from excel files
 * @Version : 1.0
 */

@Component
public abstract class GetExcel<T> {
	private static final Logger logger = LogManager.getLogger(GetExcel.class);
	
	public abstract T processRow(Row row);

	public <T> List<T> excelFile(String excelFilePath, GetExcel<T> getExcel) {
		List<T> processedData = new ArrayList<>();

		try (FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
				Workbook workbook = WorkbookFactory.create(excelFile)) {

			Sheet sheet = workbook.getSheetAt(0);

			// Start from the second row (index 1) to skip the header
			for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				if (row != null) {
					T processedRow = getExcel.processRow(row);
					processedData.add(processedRow);
				}
			}
		} catch (EncryptedDocumentException | IOException e) {
			logger.error("error occurred in excel file format", e);
		}

		return processedData;
	}
}
