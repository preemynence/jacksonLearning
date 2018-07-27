package com.preemynence.jackson.scenarios;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.preemynence.jackson.Examples;

import java.io.File;
import java.io.IOException;

public class Scenario1 implements Examples {
	@Override
	public void runExample() {
		//Read the list of JSON files in to JSON Objects.
		String file1 = "target/test1.json";
		String file2 = "target/test2.json";
		String file3 = "target/test3.json";
		String file4 = "target/test4.json";
		readJsonFilesFromLocation(file1, file2, file3, file4);

		//Parse and discard the wrong JSON and process only valid JSON.
	}

	private void readJsonFilesFromLocation(String... files) {
		for (String file : files) {
			streamReader(file);
		}
	}

	private void streamReader(String file) {
		try {
			System.out.println("Processing " + file);
			JsonFactory jsonFactory = new JsonFactory();
			JsonParser jParser = jsonFactory.createParser(new File(file));
			boolean foundError = false;
			while (jParser.nextToken() != null) {
				if (jParser.getCurrentName() != null && jParser.getCurrentName().equals("errorCode")) {
					foundError = true;
					System.out.println("Found Error Code");
					break;
				} // else if(<any other matching condition.>)
			}

			if (foundError) {
				System.out.println("we found error code.");
			} else {
				System.out.println("We did not able to find the error token");
			}

			jParser.close();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
