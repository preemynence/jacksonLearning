package com.preemynence.jackson.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.preemynence.jackson.model.Color;
import com.preemynence.jackson.model.Colors;

import java.io.File;
import java.io.IOException;

public class JacksonDataBindExample implements com.preemynence.jackson.Examples {
	@Override
	public void runExample() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Colors colors = mapper.readValue(new File(FILE_NAME), Colors.class);
			for (Color color : colors.getColors()) {
				System.out.println(color);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}