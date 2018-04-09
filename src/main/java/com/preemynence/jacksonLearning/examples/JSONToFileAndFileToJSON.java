package com.preemynence.jacksonLearning.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.preemynence.jacksonLearning.Examples;
import com.preemynence.jacksonLearning.model.Car;

import java.io.File;
import java.io.IOException;

public class JSONToFileAndFileToJSON implements Examples {

	private String fileName = "target/simpleObject.json";

	public void runExample() {
		try {
//			Create JSON file
			ObjectMapper objectMapper = new ObjectMapper();
			Car car = new Car("yellow", "renault");
			objectMapper.writeValue(new File(fileName), car);

//			Read json from file
			ObjectMapper objectMapper1 = new ObjectMapper();
			Car car1 = objectMapper1.readValue(new File(fileName), Car.class);

//          print cars
			System.out.println(car1);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
