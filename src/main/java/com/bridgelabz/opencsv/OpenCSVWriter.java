package com.bridgelabz.opencsv;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class OpenCSVWriter {

	public static final String SAMPLE_CSV_FILE_PATH = "./users.csv";
	
	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		try(
			Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH));	
		){
			StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
													.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
													.build();
			
			List<CSVUser> csvUser = new ArrayList<>();
			csvUser.add(new CSVUser("Sundar Pichai", "sundar.pichai@gmail.com", "+1-1111111111", "United States"));
			csvUser.add(new CSVUser("Satya Nadella", "satya.nadella@outlook.com", "+1-1111111111", "United States"));
			
			beanToCsv.write(csvUser);
		}
		
	}
}
