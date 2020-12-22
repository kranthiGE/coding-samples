package com.kran.processdata;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kran.processdata.model.City;
import com.kran.processdata.model.Person;
import com.kran.processdata.util.CSVFileReader;

@SpringBootApplication
public class ProcessDataApplication {
	
	static CSVFileReader csvFileReader = new CSVFileReader();

	public static void main(String[] args) {
		// SpringApplication.run(ProcessDataApplication.class, args);
		// filterPersonData();
		// filterPeopleByCities();
		// streamOnChars();
		filterPersonsByAge();
	}
	
	private static void createStreamfromFile() {
		try (Stream<String> lines = Files.lines(Paths.get("resources/people.csv"), StandardCharsets.ISO_8859_1)){
			System.out.println(lines); 
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void filterPersonsByAge() {
		try {
			List<Person> personList = csvFileReader.readCVSFile("/Users/kirankranthi/Documents/workspace-sts-3.9.0.RELEASE/process-data/src/main/resources/people.csv");
			
			
			OptionalDouble averageAge = personList.stream()
			.mapToInt(p -> p.getAge())
			.filter(age -> age > 20)
			.average();
			
			double avg = averageAge.orElseThrow(null);
			System.out.println(avg);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void filterPersonData() {
		try {
			List<Person> personList = csvFileReader.readCVSFile("/Users/kirankranthi/Documents/workspace-sts-3.9.0.RELEASE/process-data/src/main/resources/people.csv");
			System.out.println(personList.stream()
					.map(p -> p.getName()).filter(name -> !name.isEmpty()).count()); 
			
			List<String> filteredPerson = personList.stream()
			.map(p -> p.getName()).filter(name -> !name.isEmpty())
			.collect(Collectors.toList());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void filterPeopleByCities() {
		List<City> cities = new ArrayList<City>();
		//fetch person data and associate each person to a city
		List<Person> personList = null;
		try {
			personList = csvFileReader.readCVSFile("/Users/kirankranthi/Documents/workspace-sts-3.9.0.RELEASE/process-data/src/main/resources/people.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = 0;
		for (Person person : personList) {
			count ++;
			// add cities
			City city = (count%2 == 0 ?  new City("Hyderabad", person) :  new City("Bangalore", person));
			System.out.println("city name = " + city.getCityName() + ", person name = " + person.getName());
			cities.add(city);
		}
		//Function mapper, filters cities by Bangalore city and prints people name living in this city
		cities.stream()
				.filter(city -> city.getCityName().equals("Bangalore"))
				.flatMap(city -> Stream.of(city.getPerson()))
				.map(p -> p.getName())
				.forEach(name -> System.out.println(name));
	}
	
	private static void streamOnChars() {
		String str = "a beautiful water stream near sringeri gushing through bushes of herbal plants";
		
		str.chars()
		.mapToObj(codePoint -> Character.toString((char)codePoint))
		.filter(letter -> !letter.equals(" "))
		.distinct()
		.sorted()
		.skip(5)
		.limit(10)
		.forEach(letter -> System.out.print(letter));
		
		
		
		
	}
	
}
