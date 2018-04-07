package com.preemynence.jacksonLearning;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.preemynence.jacksonLearning.model.Car;

import java.io.File;
import java.io.IOException;

public class Application {

	public static void main(String args[]){
		try {
//			Create JSON file
			ObjectMapper objectMapper = new ObjectMapper();
			Car car = new Car("yellow", "renault");
			objectMapper.writeValue(new File("target/car.json"), car);

//			Read json from file
			ObjectMapper objectMapper1 = new ObjectMapper();
			Car car1 = objectMapper1.readValue(new File("target/car.json"),Car.class);

//          print cars
			System.out.print(car1);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
