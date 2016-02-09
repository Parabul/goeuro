package com.anarbek.projects.goeuro.rest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.anarbek.projects.goeuro.entity.Suggest;
import com.anarbek.projects.goeuro.utils.CsvUtil;

public class Runner {

	private static final String default_file_name = "suggests.csv";

	public static void main(String[] args) throws IOException {
		if (args == null || args.length != 1)
			throw new IllegalArgumentException(
					"Program expects only one parameter - the placename");

		GoeuroApiClient client = new GoeuroApiClient();
		List<Suggest> suggests = client.getSuggests(args[0]);
		File directory = new File(".");
		String fileName = directory.getCanonicalPath() + File.separator
				+ default_file_name;

		CsvUtil.writeCsvFile(fileName, suggests, Suggest.file_header);
		
		System.out.println("Please find suggests.csv in current directory");
	}

}
