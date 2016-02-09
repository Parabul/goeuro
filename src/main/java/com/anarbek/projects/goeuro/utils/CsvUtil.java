package com.anarbek.projects.goeuro.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CsvUtil {

	private CsvUtil() {
	}

	public static void writeCsvFile(String fileName,
			List<? extends Recordable> recordables, Object[] title) {

		FileWriter fileWriter = null;

		CSVPrinter csvFilePrinter = null;
		try {
			fileWriter = new FileWriter(fileName);
			csvFilePrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);

			csvFilePrinter.printRecord(title);

			for (Recordable recordable : recordables) {
				csvFilePrinter.printRecord(recordable.getRecord());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				csvFilePrinter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
