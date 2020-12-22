package com.kran.processdata.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.kran.processdata.model.Person;
import com.opencsv.CSVReader;

public class CSVFileReader {
	
	private List<Person> personData;

	public static void main(String[] args) {
		

	}

	/**
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<Person> readCVSFile(String filePath) throws FileNotFoundException, IOException {
		personData = new ArrayList<>();
		try(CSVReader csvReader = new CSVReader(new FileReader(filePath))){
			String[] values = null;
			while( (values = csvReader.readNext()) != null) {
				Integer ageValue = 0;
				if(values[1] != null) {
					ageValue = Integer.valueOf(values[1]);
				}
				
				Person person = new Person(values[0], ageValue);
				personData.add(person);
			}
		}		
		return personData;
	}
}
