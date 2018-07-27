package com.preemynence.jackson.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.preemynence.jackson.Examples;
import com.preemynence.jackson.model.Car;

import java.io.File;
import java.io.IOException;

public class JSONToFileAndFileToJSON implements Examples {

	public void runExample() {
		try {
//			Create JSON file
			ObjectMapper objectMapper = new ObjectMapper();
			Car car = new Car("yellow", "renault");
			objectMapper.writeValue(new File(FILE_NAME), car);

//			Read json from file
			ObjectMapper objectMapper1 = new ObjectMapper();
			Car car1 = objectMapper1.readValue(new File(FILE_NAME), Car.class);

//          print cars
			System.out.println(car1);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
